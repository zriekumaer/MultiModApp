package com.ust.user.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ust.common.bo.Response;
import com.ust.common.bo.SearchDTO;
import com.ust.common.constants.AppConstant;
import com.ust.common.enums.RoleNames;
import com.ust.user.service.UserService;
import com.ust.user.service.bo.UserBO;

@Controller
public class UserController1 {

    @Autowired
    private UserService userService;

    @Value("${max.result.per.page}")
    private int maxResults;

    @Value("${max.card.display.on.pagination.tray}")
    private int maxPaginationTraySize;

    @GetMapping("/")
    public ModelAndView home(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                             @RequestParam(value = "size", defaultValue = "4", required = false) Integer size,
                             HttpServletRequest request, HttpServletResponse response) {

        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        List<String> list = new ArrayList<String>();
        
        for (SimpleGrantedAuthority authority : authorities) {
        	list.add(authority.getAuthority());
        }

        ModelAndView modelAndView = new ModelAndView();
        if (list.contains(RoleNames.ADMIN.name())) {
            modelAndView.setViewName("home");
            Page<UserBO> allUsers = userService.listUsers(PageRequest.of(page, size, Sort.by("firstName")));
            modelAndView.addObject("allUsers", allUsers);
            modelAndView.addObject("maxTraySize", size);
            modelAndView.addObject("currentPage", page);
        } else {
            modelAndView.setViewName("user-home");
            UserBO user = userService.findUserByEmail(request.getUserPrincipal().getName());
            modelAndView.addObject("currentUser", user);
        }

        return modelAndView;
    }

    @GetMapping("/searchBox")
    public ModelAndView searchByTerm(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                                     @RequestParam(value = "size", defaultValue = "4", required = false) Integer size,
                                     @RequestParam(value = "searchTerm", required = false) String searchTerm) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        Page<UserBO> allUsers = userService.searchByTerm(searchTerm.trim(), PageRequest.of(page, size, Sort.by("firstName")));
        modelAndView.addObject("allUsers", allUsers);
        modelAndView.addObject("maxTraySize", size);
        modelAndView.addObject("currentPage", page);
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView search() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search");
        return modelAndView;
    }

    @PostMapping("/searchSubmit")
    public ModelAndView searchSubmit(@ModelAttribute SearchDTO searchDto) {
        List<UserBO> result = userService.searchBy(searchDto.getSearchKeyword(), searchDto.getCriteria());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search");
        modelAndView.addObject("result", result);
        return modelAndView;
    }

    @GetMapping("/addNewUser")
    public ModelAndView addNewUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("create-user");
        return modelAndView;
    }

    @ResponseBody
    @PostMapping("/save")
    public Response update(@RequestBody UserBO user) {
    	UserBO dbUser = userService.findById(user.getId());
        dbUser.setFirstName(user.getFirstName());
        dbUser.setLastName(user.getLastName());
        userService.saveUser(dbUser);
        return new Response(302, AppConstant.SUCCESS, "/");
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserBO user) {
        String result = "redirect:/";
        UserBO dbUser = userService.findUserByEmail(user.getEmail());
        if (user.getFirstName() == null || user.getFirstName().trim().isEmpty()) {
            result = "redirect:/addNewUser?error=Enter valid fist name";
        } else if (user.getLastName() == null || user.getLastName().trim().isEmpty()) {
            result = "redirect:/addNewUser?error=Enter valid last name";
        } else if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            result = "redirect:/addNewUser?error=Enter valid email";
        } else if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            result = "redirect:/addNewUser?error=Enter valid password";
        } else if (StringUtils.isEmpty(user.getRoleName())) {
            result = "redirect:/addNewUser?error=Select a valid Role";
        }
        if (dbUser == null) {
            userService.saveUser(user);
        } else {
            result = "redirect:/addNewUser?error=User Already Exists!";
        }

        return result;
    }

    @GetMapping("/delete/{userId}")
    public String delete(@PathVariable Integer userId) {
        userService.removeById(userId);
        return "redirect:/";
    }

    @ResponseBody
    @GetMapping("/removeAll")
    public Boolean removeAll() {
        return userService.removeAll();
    }

    @GetMapping("/403")
    public ModelAndView accessDenied() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("403");
        return modelAndView;
    }

    @GetMapping("/error")
    public ModelAndView error() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }
}