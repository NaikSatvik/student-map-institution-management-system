package com.internproject.springpr.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.internproject.springpr.domain.Faculty;
import com.internproject.springpr.domain.Guardian;
import com.internproject.springpr.domain.User;
import com.internproject.springpr.repository.FacultyRepository;
import com.internproject.springpr.repository.GuardianRepository;
import com.internproject.springpr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("stuEmail")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private FacultyRepository facRepo;

    @Autowired
    private GuardianRepository gurRepo;

    @RequestMapping("/index")
    public String redirectToLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public String authenticateUser(@RequestParam("inlineRadioOptions") String inlineRadioOptions,@RequestParam("stuEmail") String stuEmail,@RequestParam("stuPass") String stuPass,@RequestParam("stuSem") String stuSem,@RequestParam("stuName") String stuName,Model model) {
        User u = null;
        Faculty f = null;
        Guardian g = null;
        String x = inlineRadioOptions;
        System.out.println(inlineRadioOptions);
        if (x.equals("student")) {
            try {
                u = userRepo.findByStuEmailAndStuPassAndStuSem(stuEmail,stuPass,stuSem);
    
            } catch (Exception e) {
                System.out.println("User Not Found !!");
            }
            if(u!=null) {
                model.addAttribute("stuEmail", stuEmail);
                return "index";
            }
            model.addAttribute("error", "Oops!! User Not Found.");
            return "login";
        }
        else if (x.equals("faculty")) {
            try {
                f = facRepo.findByFacEmailAndFacPass(stuEmail, stuPass);
            } catch (Exception e) {
                System.out.println("Faculty Not Found !!");
            }
            if(f!=null) {
                model.addAttribute("stuEmail", stuEmail);
                return "index";
            }
            model.addAttribute("error", "Oops!! Faculty Not Found.");
            return "login";
        }
        else if (x.equals("guardian")) {
            try {
                g = gurRepo.findByGurEmailAndGurPassAndGurStudentmail(stuEmail, stuPass, stuName);
            } catch (Exception e) {
                System.out.println("Guardian Not Found !!");
            }
            if(g!=null) {
                model.addAttribute("stuEmail", stuEmail);
                return "index";
            }
            model.addAttribute("error", "Oops!! Faculty Not Found.");
            return "login";
        }
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.invalidate();
        return "login";
    }
}