package com.ust.helpapp.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.common.enums.StatusEnum;
import com.ust.common.response.Response;
import com.ust.common.response.SingleResponse;
import com.ust.helpapp.entity.ChangeStatus;
import com.ust.helpapp.entity.Ticket;
import com.ust.helpapp.service.TicketService;
import com.ust.helpapp.service.bo.Summary;

@RestController
@RequestMapping(value="/api/ticket")
@CrossOrigin(origins="*")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@Autowired
	protected JwtTokenUtil jwtTokenUtil;
	
//	@Autowired
//	private UserService userService;
	
	@PostMapping
	@PreAuthorize("hasAnyRole('CUSTOMER')")
	public ResponseEntity<SingleResponse<Ticket>> createOrUpdate(HttpServletRequest request, @RequestBody Ticket ticket,
			BindingResult result){
		SingleResponse<Ticket> response = new SingleResponse<Ticket>();
		try {
			validateCreateTicket(ticket, result);
			
			if(result.hasErrors()) {
				List<ObjectError> errorList = result.getAllErrors();
				List<String> strErrors = new ArrayList<String>();
				for (ObjectError objectError: errorList)
					strErrors.add(objectError.getDefaultMessage());
				
				response.setErrors(strErrors);
				return ResponseEntity.badRequest().body(response);
			}
			ticket.setStatus(StatusEnum.getStatus("New").toString());
			ticket.setNumber(generateNumber());
			Ticket ticketPersisted =(Ticket) this.ticketService.createOrUpdate(ticket);
			response.setData(ticketPersisted);
		}catch(Exception e) {
			
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		
		return ResponseEntity.ok(response);
	}
	
	private void validateCreateTicket(Ticket ticket, BindingResult result) {
		if(ticket.getTitle()==null || ticket.getTitle().equals("")) {
			result.addError(new ObjectError("Ticket","Ticket not informed"));
		}
	}
	
	private User userFromRequest(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		String email = jwtTokenUtil.getUsernameFromToken(token);
		return this.userService.findbyEmail(email);
	}
	
	
	private Integer generateNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}
	
	@PutMapping
	@PreAuthorize("hasAnyRole('CUSTOMER')")
	public ResponseEntity<Response<Ticket>> update(HttpServletRequest request, @RequestBody Ticket ticket,
			BindingResult result){
		SingleResponse<Ticket> response = new SingleResponse<Ticket>();
		try {
			validateUpdateTicket(ticket,result);
			if(result.hasErrors()) {
				result.getAllErrors().forEach(error-> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			Ticket ticketCurrent = this.ticketService.findById(ticket.getId());
			ticket.setStatus(ticket.getStatus());
			ticket.setUser(userFromRequest(request));
			ticket.setDate(ticketCurrent.getDate());
			ticket.setNumber(ticketCurrent.getNumber());
			if(ticketCurrent.getAssignedUser()!=null) {
				ticket.setAssignedUser(ticketCurrent.getAssignedUser());
			}
			Ticket ticketPersisted = this.ticketService.createOrUpdate(ticket);
			response.setData(ticketPersisted);
		}catch(Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		
		return ResponseEntity.ok(response);
	}
	
	
	private void validateUpdateTicket(Ticket ticket, BindingResult result) {
		if(ticket.getId()==null || ticket.getId().equals("")) {
			result.addError(new ObjectError("Ticket","Ticket not informed"));
		}
	}
	
	@GetMapping(value="{id}")
	@PreAuthorize("hasAnyRole('CUSTOMER','TECHNICIAN')")
	public ResponseEntity<SingleResponse<Ticket>> findById(@PathVariable("id") String id){
		SingleResponse<Ticket> response = new SingleResponse<Ticket>();
		Ticket ticket = this.ticketService.findById(id);
		if(ticket==null) {
			response.getErrors().add("Register id not found "+ id);
			return ResponseEntity.badRequest().body(response);
		}
		List<ChangeStatus> changes = new ArrayList<ChangeStatus>();
		Iterable<ChangeStatus> changesCurrent = this.ticketService.listChangeStatus(ticket.getId());
		changesCurrent.forEach((c) -> {
			c.setTicket(null);
			changes.add(c);
		});
		
		ticket.setChanges(changes);
		response.setData(ticket);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping(value="{id}")
	@PreAuthorize("hasAnyRole('CUSTOMER')")
	public ResponseEntity<Response<String>> delete(@PathVariable("id") String id){
		SingleResponse<String> response = new SingleResponse<String>();
		Ticket ticket = this.ticketService.findById(id);
		if(ticket==null) {
			response.getErrors().add("Register id not found "+id);
			return ResponseEntity.badRequest().body(response);
		}
		this.ticketService.delete(id);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="{page}/{count}")
	@PreAuthorize("hasAnyRole('CUSTOMER','TECHNICIAN')")
	public ResponseEntity<SingleResponse<Page<Ticket>>> findAll(HttpServletRequest request, @PathVariable("page") int page,
			@PathVariable("count") int count){
		SingleResponse<Page<Ticket>> response = new SingleResponse<Page<Ticket>>();
		Page<Ticket> tickets=null;
		User userRequest = userFromRequest(request);
		if(userRequest.getProfile().equals(ProfileEnum.ROLE_TECHNICIAN)) {
			tickets = this.ticketService.listTicket(page, count);
		}else {
			tickets = this.ticketService.findByCurrentUser(page, count, userRequest.getId());
		}
		response.setData(tickets);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="{page}/{count}/{number}/{title}/{status}/{priority}/{assigned}")
	@PreAuthorize("hasAnyRole('CUSTOMER','TECHNICIAN')")
	public ResponseEntity<SingleResponse<Page<Ticket>>> findByParameters(HttpServletRequest request, 
			@PathVariable("page") int page,
			@PathVariable("count") int count,
			@PathVariable("number") int number,
			@PathVariable("title") String title,
			@PathVariable("status") String status,
			@PathVariable("priority") String priority,
			@PathVariable("assigned") boolean assigned){
		
		title = title.equals("uninformed") ? "" : title;
		status = status.equals("uninformed") ? "" : status;
		priority = priority.equals("uninformed") ? "" : priority;
		
		SingleResponse<Page<Ticket>> response = new SingleResponse<Page<Ticket>>();
		Page<Ticket> tickets = null;
		
		if(number>0) {
			tickets = this.ticketService.findByNumber(page, count, number);
		}else {
			User userRequest = userFromRequest(request);
			if(userRequest.getProfile().equals(ProfileEnum.ROLE_TECHNICIAN)) {
				if(assigned) {
					tickets = this.ticketService.findByParametersAndAssignedUser(page, count, title, status, priority, userRequest.getId());
				}else {
					tickets = this.ticketService.findByParameters(page, count, title, status, priority);
				}
			}else if(userRequest.getProfile().equals(ProfileEnum.ROLE_CUSTOMER)){
				tickets = this.ticketService.findByParametersAndCurrentUser(page, count, title, status, priority, userRequest.getId());
			}
		}
		
		response.setData(tickets);
		return ResponseEntity.ok(response);
	}
	
	
	@PutMapping(value="{id}/{status}")
	@PreAuthorize("hasAnyRole('CUSTOMER','TECHNICIAN')")
	public ResponseEntity<SingleResponse<Ticket>> changeStatus(
			@PathVariable("id") String id,
			@PathVariable("status") String status,
			HttpServletRequest request,
			@RequestBody Ticket ticket,
			BindingResult result){
		SingleResponse<Ticket> response = new SingleResponse<Ticket>();
		
		try {
			validateChangeStatus(id, status, result);
			if(result.hasErrors()) {
				result.getAllErrors().forEach(error->response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			Ticket ticketCurrent = this.ticketService.findById(id);
			ticketCurrent.setStatus(StatusEnum.getStatus(status));
			if(status.equals("Assigned"))ticketCurrent.setAssignedUser(userFromRequest(request));
			Ticket ticketPersisted= (Ticket) this.ticketService.createOrUpdate(ticketCurrent);
			ChangeStatus changeStatus = new ChangeStatus();
			changeStatus.setUserChange(userFromRequest(request));
			changeStatus.setDateChangeStatus(new Date());
			changeStatus.setStatus(StatusEnum.getStatus(status));
			changeStatus.setTicket(ticketPersisted);
			this.ticketService.createChangeStatus(changeStatus);
			response.setData(ticketPersisted);
		}catch(Exception e){
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	private void validateChangeStatus(String id,String status, BindingResult result) {
		if (id == null || id.equals("")) {
			result.addError(new ObjectError("Ticket", "Id no information"));
			return;
		}
		if (status == null || status.equals("")) {
			result.addError(new ObjectError("Ticket", "Status no information"));
			return;
		}
	}
	
	@GetMapping(value = "/summary")
	public ResponseEntity<SingleResponse<Summary>> findChart() {
		SingleResponse<Summary> response = new SingleResponse<Summary>();
		Summary chart = new Summary();
		int amountNew = 0;
		int amountResolved = 0;
		int amountApproved = 0;
		int amountDisapproved = 0;
		int amountAssigned = 0;
		int amountClosed = 0;
		Iterable<Ticket> tickets = ticketService.findAll();
		if (tickets != null) {
			for (Iterator<Ticket> iterator = tickets.iterator(); iterator.hasNext();) {
				Ticket ticket = iterator.next();
				if(ticket.getStatus().equals(StatusEnum.NEW)){
					amountNew ++;
				}
				if(ticket.getStatus().equals(StatusEnum.RESOLVED)){
					amountResolved ++;
				}
				if(ticket.getStatus().equals(StatusEnum.APPROVED)){
					amountApproved ++;
				}
				if(ticket.getStatus().equals(StatusEnum.DISAPPROVED)){
					amountDisapproved ++;
				}
				if(ticket.getStatus().equals(StatusEnum.ASSIGNED)){
					amountAssigned ++;
				}
				if(ticket.getStatus().equals(StatusEnum.CLOSED)){
					amountClosed ++;
				}
			}	
		}
		chart.setAmountNew(amountNew);
		chart.setAmountResolved(amountResolved);
		chart.setAmountApproved(amountApproved);
		chart.setAmountDisapproved(amountDisapproved);
		chart.setAmountAssigned(amountAssigned);
		chart.setAmountClosed(amountClosed);
		response.setData(chart);
		return ResponseEntity.ok(response);
	}
}