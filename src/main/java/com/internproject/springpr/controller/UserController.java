package com.internproject.springpr.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.internproject.springpr.domain.Faculty;
import com.internproject.springpr.domain.SignUp;
import com.internproject.springpr.domain.User;
import com.internproject.springpr.repository.FacultyRepository;
import com.internproject.springpr.repository.SignUpRepository;
import com.internproject.springpr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("mail")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private FacultyRepository facRepo;

    @Autowired
    private SignUpRepository signupRepo;

    @RequestMapping("/index")
    public String redirectToLogin() {
        return "login";
    }

    @RequestMapping("/indexFac")
    public String redirectToindexFac() {
        return "indexFac";
    }

    @RequestMapping("/signup")
    public String redirectToSignUp() {
        return "SignUp";
    }

    @RequestMapping("/insertdata-signup")
    public String insertSignUpData(@RequestParam("role") String role,@RequestParam("username") String username,@RequestParam("mailid") String mailid,@RequestParam("pass") String pass,@RequestParam("confpass") String confpass, Model model, SignUp signup) {
        String pass1 = pass;
        String pass2 = confpass;
        SignUp s = null;
        if (pass1.equals(pass2)) {
            s = signupRepo.findByMailid(mailid);
            if (s == null) {
                signupRepo.save(signup);
                model.addAttribute("error", "You have been signed up Successfully !!");
            } else {
                model.addAttribute("error", "Email-ID already exists. Try again with different email-id.");
                return "SignUp";
            }
            return "login";
        } else {
            model.addAttribute("error", "Your password dosen't matched. Please try to SignUp again.");
        }
        return "SignUp";
    }

    @RequestMapping("/login")
    public String authenticateUser(@RequestParam("role") String role,@RequestParam("mail") String mail,@RequestParam("pass") String pass,Model model) {
        String x = role;
        System.out.println(role);
        if (x == null) {
            model.addAttribute("error", "Please select your role (i.e. You Are)");
        } else {
            if (x.equals("admin")) {
                if (signupRepo.findByRoleAndMailidAndPass(role, mail, pass) != null) {
                    model.addAttribute("mail", mail);
                    return "indexAdmin";
                } else {
                    model.addAttribute("error", "You have entered incorrect credentials. Please try again.");
                    return "login";
                }
            } else if (x.equals("student")) {
                if (signupRepo.findByRoleAndMailidAndPass(role, mail, pass) != null) {
                    if (userRepo.count(mail) == null) {
                        model.addAttribute("mail", mail);
                        return "StuProfile";
                    } else {
                        model.addAttribute("mail", mail);
                        return "indexStu";
                    }
                } else {
                    model.addAttribute("error", "You have entered incorrect credentials. Please try again.");
                    return "login";
                }
            } else if (x.equals("faculty")) {
                if (signupRepo.findByRoleAndMailidAndPass(role, mail, pass) != null) {
                    //System.out.println(facRepo.count(mail));
                    if (facRepo.count(mail) == null) {
                        model.addAttribute("mail", mail);
                        return "FacProfile";
                    } else {
                        model.addAttribute("mail", mail);
                        return "indexFac";
                    }
                } else {
                    model.addAttribute("error", "You have entered incorrect credentials. Please try again.");
                    return "login";
                }
            } else if (x.equals("guardian")) {
                if (signupRepo.findByRoleAndMailidAndPass(role, mail, pass) != null) {
                    model.addAttribute("mail", mail);
                    return "indexGur";
                } else {
                    model.addAttribute("error", "You have entered incorrect credentials. Please try again.");
                    return "login";
                }
            } else {
                return "login";
            }
        }
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.invalidate();
        return "login";
    }

    @RequestMapping("/save-FacProfile")
    public String saveFacProfile(Model model, Faculty faculty) {
        facRepo.save(faculty);
        model.addAttribute("error", "You have completed your profile. Kindly Login Again.");
        return "login";
    }

    @RequestMapping("/save-StuProfile")
    public String saveStuProfile(Model model, User user) {
        userRepo.save(user);
        model.addAttribute("error", "You have completed your profile. Kindly Login Again.");
        return "login";
    }

    @RequestMapping("/goto-yourstudents")
    public String getallstu(Model model) {
        model.addAttribute("stubysem", userRepo.findAll());
        return "YourStudents";
    }

    @RequestMapping("/yourstudents")
    public String getBySem(@RequestParam ("stuSem") String stuSem, Model model) {
        //System.out.println(stuSem);
        model.addAttribute("stubysem", userRepo.findByStuSem(stuSem));
        return "YourStudents";
    }

    @RequestMapping("/profile")
    public String redirectToProfile(@ModelAttribute("mail") String mail,Model model) {
        model.addAttribute("facprofile", facRepo.findByFacEmail(mail));
        return "FacProfileDash";
    }

    @RequestMapping("/edit-profile")
    public String redirectToEditProfile(@ModelAttribute("mail") String mail,Model model) {
        model.addAttribute("facprofile", facRepo.findByFacEmail(mail));
        return "EditFacProfile";
    }

    @RequestMapping("/sprofile")
    public String redirectToSProfile(@ModelAttribute("mail") String mail,Model model) {
        model.addAttribute("StuProfile", userRepo.findByStuEmail(mail));
        return "StuProfileDash";
    }

    @RequestMapping("/edit-sprofile")
    public String redirectToEditSProfile(@ModelAttribute("mail") String mail,Model model) {
        model.addAttribute("Stuprofile", userRepo.findByStuEmail(mail));
        return "EditStuProfile";
    }

    @RequestMapping("/indexStu")
    public String redirectToindexStu() {
        return "indexStu";
    }

    @Transactional
    @RequestMapping("/updateFaculty") 
    public String updateFaculty(@RequestParam("facEmail") String facEmail,@RequestParam("facMobile") String facMobile,@RequestParam("facAddress") String facAddress,@RequestParam("facPincode") String facPincode,@RequestParam("facExp") String facExp,@RequestParam("facQuali") String facQuali,@RequestParam("facSpeci") String facSpeci) {
        facRepo.update(facEmail, facMobile, facAddress, facPincode, facExp, facQuali, facSpeci);
        return "indexFac";
    }

    @Transactional
    @RequestMapping("/updateStudent")
    public String updateUser(@RequestParam("stuEmail") String stuEmail,@RequestParam("stuMobile") String stuMobile,@RequestParam("stuAddress") String stuAddress,@RequestParam("stuPincode") String stuPincode,@RequestParam("stuHobby") String stuHobby) {
        userRepo.update(stuEmail,stuMobile,stuAddress,stuPincode,stuHobby);
        return "indexStu";
    }

    @Transactional
    @RequestMapping("/update-sem")
    public String updatestusem(@RequestParam("stuEmail") String stuEmail,@RequestParam("stuSem") String stuSem,Model model) {
        userRepo.update(stuEmail, stuSem);
        model.addAttribute("stubysem", userRepo.findAll());
        return "YourStudents";
    }
}