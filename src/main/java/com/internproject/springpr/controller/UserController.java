package com.internproject.springpr.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date; 
import com.internproject.springpr.domain.Faculty;
import com.internproject.springpr.domain.Guardian;
import com.internproject.springpr.domain.GurQuery;
import com.internproject.springpr.domain.Notice;
import com.internproject.springpr.domain.SignUp;
import com.internproject.springpr.domain.StudentQuery;
import com.internproject.springpr.domain.User;
import com.internproject.springpr.domain.follow;
import com.internproject.springpr.repository.FacultyRepository;
import com.internproject.springpr.repository.GuardianRepository;
import com.internproject.springpr.repository.GurQueryRepository;
import com.internproject.springpr.repository.NoticeRepository;
import com.internproject.springpr.repository.Res_SemOneRepository;
import com.internproject.springpr.repository.SignUpRepository;
import com.internproject.springpr.repository.StudentQueryRepository;
import com.internproject.springpr.repository.UserRepository;
import com.internproject.springpr.repository.followRepository;
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

    @Autowired
    private StudentQueryRepository stuqueryRepo;

    @Autowired
    private GuardianRepository gurRepo;

    @Autowired
    private NoticeRepository noteRepo;

    @Autowired
    private followRepository folrepo;

    @Autowired
    private Res_SemOneRepository semOneRepo;

    @Autowired
    private NoticeRepository noticeRepo;

    @Autowired
    private GurQueryRepository gurQueryRepo;

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

    @Transactional
    @RequestMapping("/insertdata-signup")
    public String insertSignUpData(@RequestParam("role") String role,@RequestParam("username") String username,@RequestParam("mailid") String mailid,@RequestParam("stumailid") String stumailid,@RequestParam("pass") String pass,@RequestParam("confpass") String confpass, Model model, SignUp signup) {
        String pass1 = pass;
        String pass2 = confpass;
        SignUp s = null;

        if (pass1.equals(pass2)) {
            s = signupRepo.findByMailid(mailid);
            if (role.equals("guardian")) {
                signupRepo.updateGurEntry(mailid, stumailid, username, pass);
                model.addAttribute("error", "You have been signed up Successfully !!");
            } else if (s == null) {
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
                    System.out.println(pass);
                    if (facRepo.count(mail) == null) {
                        if (pass.equals("GNUFAC")) {
                            model.addAttribute("mail", mail);
                            return "ResetFacPass";
                        } else {
                            model.addAttribute("mail", mail);
                            return "FacProfile";
                        }
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
                    if (gurRepo.count(mail) == null) {
                        model.addAttribute("mail", mail);
                        return "GurProfile";
                    } else {
                        model.addAttribute("mail", mail);
                        return "indexGur";
                    }
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

    @Transactional
    @RequestMapping("/upFacPass")
    public String updateFacPass(@ModelAttribute("mail") String mail,@RequestParam("pass") String pass,@RequestParam("confpass") String confpass,Model model) {
        String pass1 = pass;
        String pass2 = confpass;

        if (pass1.equals(pass2)) {
            signupRepo.updateFacPass(mail, pass);
            model.addAttribute("error", "Your Password has been changed successfully. Please Login Again");
            return "login";
        } else {
            model.addAttribute("error", "Your password dosen't matched. Please try to change your password again.");
            return "ResetFacPass";
        }
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

    // @Transactional
    // @RequestMapping("/updateStudent")
    // public String updateUser(@RequestParam("stuEmail") String stuEmail,@RequestParam("stuMobile") String stuMobile,@RequestParam("stuAddress") String stuAddress,@RequestParam("stuPincode") String stuPincode,@RequestParam("stuHobby") String stuHobby) {
    //     userRepo.update(stuEmail,stuMobile,stuAddress,stuPincode,stuHobby);
    //     return "indexStu";
    // }

    @Transactional
    @RequestMapping("/update-sem")
    public String updatestusem(@RequestParam("stuEmail") String stuEmail,@RequestParam("stuSem") String stuSem,Model model) {
        userRepo.update(stuEmail, stuSem);
        model.addAttribute("stubysem", userRepo.findAll());
        return "YourStudents";
    }

    // Student Query
    @RequestMapping("/StudentQuery")
    public String redirecttoStuQuery() {
        return "StudentQuery";
    }

    @RequestMapping("/Student")
    public String addquery(StudentQuery query) {
        stuqueryRepo.save(query);
        return "StudentQuery";
    }

    @RequestMapping("/UploadGrades")
    public String redirectToupldGrades() {
        return "UploadGrades";
    }

    @RequestMapping("/UploadNotice")
    public String redirectToUploadNotice() {
        return "UploadNotice";
    }

    @RequestMapping("/SaveNotice")
    public String saveNotice(Model model, Notice notice ) {
        noteRepo.save(notice);
        model.addAttribute("error","Notice has been uploaded");
        return "UploadNotice";
    }

    @RequestMapping("/revertStuQueries")
    public String redirectTostuqueries(Model model) {
        String reply = null;
        model.addAttribute("getStuQ", stuqueryRepo.findByReply(reply));
        return "RevStuQueries";
    }
    @Transactional
    @RequestMapping("/saveReply")
    public String updateStuQueryReply(@RequestParam ("stuQuery") String stuQuery,@RequestParam ("reply") String reply,  Model model) {
        stuqueryRepo.updatestureply(stuQuery, reply);
        String reply1 = null;
        model.addAttribute("msg", "Message reverted successfully");
        model.addAttribute("getStuQ", stuqueryRepo.findByReply(reply1));
        return "RevStuQueries";
    }

    @RequestMapping("/revertGurQueries")
    public String redirectTogurqueries(Model model) {
        String reply = null;
        model.addAttribute("getGurQ", gurQueryRepo.findByReply(reply));
        return "RevGurQueries";
    }
    @Transactional
    @RequestMapping("/saveReplyGur")
    public String updateGurQueryReply(@RequestParam ("gurQueryContent") String gurQueryContent ,@RequestParam ("reply") String reply,  Model model) {
        gurQueryRepo.updategurreply(gurQueryContent, reply);
        String reply1 = null;
        model.addAttribute("msg", "Message reverted successfully");
        model.addAttribute("getGurQ", gurQueryRepo.findByReply(reply1));
        return "RevGurQueries";
    }

    // Admin Module Start

    @RequestMapping("/goto-viewStudents")
    public String getallstuad(Model model) {
        model.addAttribute("stubysemadmin", userRepo.findAll());
        return "viewstudentsadmin";
    }

    @RequestMapping("/goto-viewfaculty")
    public String getallfacad(Model model) {
        model.addAttribute("facultyadmin", facRepo.findAll());
        return "viewfacultyadmin";
    }

    @RequestMapping("/goto-viewparent")
    public String getallparentad(Model model) {
        model.addAttribute("guaadmin",gurRepo.findAll());
        return "viewparentadmin";
    }

    @Transactional
    @RequestMapping("/update-sem-admin")
    public String updatestusemadmin(@RequestParam("stuEmail") String stuEmail,@RequestParam("stuSem") String stuSem,Model model) {
        userRepo.updateSem(stuEmail, stuSem);
        model.addAttribute("stubysemadmin", userRepo.findAll());
        return "viewstudentsadmin";
    }

    @Transactional
    @RequestMapping("/update-faculty-admin")
    public String updatefacadmin(@RequestParam("facEmail") String facEmail,@RequestParam("facDesig") String facDesig,Model model) {
        facRepo.updatefac(facEmail, facDesig);
        model.addAttribute("facultyadmin", facRepo.findAll());
        return "viewfacultyadmin";
    }

    @RequestMapping("/save-facpassandid")
    public String saveFacpass(Model model, SignUp signUp) {
        signupRepo.save(signUp);
        //model.addAttribute("error", "You have completed your profile. Kindly Login Again.");
        return "facultypassandemail";
    }

    @RequestMapping("/indexAdmin")
    public String redirectToindexAdmin() {
        return "indexAdmin";
    }
    // Admin Module End

    // Student Module (Follow Feature) Start

    @RequestMapping("/find-friends")
    public String redirectToFindFriends(Model model) {
        model.addAttribute("listStudents",userRepo.findAll());
        //System.out.println(x);
        return "FindFriends";
    }

    @RequestMapping("/follow")
    public String insfollow(Model model,follow fol) {
        folrepo.save(fol);
        model.addAttribute("msg","Request sent");
        return "FindFriends";
    }

    @RequestMapping("/check-requests")
    public String followBack(@ModelAttribute("mail") String mail,Model model) {
        String status = "Pending";
        model.addAttribute("folbacklist",folrepo.findByStuNameAndStatus(mail,status));
        return "PendingRequests";
    }
    @Transactional
    @RequestMapping("/onAccept")
    public String onAccept(@ModelAttribute("mail") String mail,@RequestParam ("sEmail") String sEmail,String status) {
        status = "Accept";
        folrepo.updateA(mail, sEmail, status);
        return "PendingRequests";
    }

    @Transactional
    @RequestMapping("/onDecline")
    public String onDecline(@ModelAttribute("mail") String mail,@RequestParam ("sEmail") String sEmail,String status1) {
        status1 = "Decline";
        folrepo.updateB(mail, sEmail, status1);
        return "PendingRequests";
    }

    @RequestMapping("/friends")
    public String redirectToYourFriends(@ModelAttribute("mail") String mail,Model model) {
        String status = "Accept";
        model.addAttribute("acceptlist",folrepo.findByStuNameAndStatus(mail,status));
        return "YourFriends";
    }

    @RequestMapping("/getResult")
    public String redirectToResult(@ModelAttribute("mail") String mail, String semester, Model model) {
        semester = "1";
        model.addAttribute("result", semOneRepo.findByEmailidAndSemester(mail, semester));
        return "GetResult";
    }

    @RequestMapping("/getNotice")
    public String redirectToNotice(Model model) throws Exception {
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);  
        System.out.println(strDate);
        model.addAttribute("noticeres", noticeRepo.findByExpDate(strDate));
        return "GetNotice";
    }

    @RequestMapping("/repliesStu")
    public String redirectToStuQueryResponse(@ModelAttribute("mail") String mail, Model model) {
        model.addAttribute("getResponsesStu", stuqueryRepo.findByStuEmail(mail));
        return "StuQueryResponses";
    }

    // Student Module (Follow Feature) End

    // Guardian Module Start

    @RequestMapping("/indexGur")
    public String redirectToGurDash() {
        return "indexGur";
    }

    @RequestMapping("/queryform")
    public String redirectToGurQuery() {
        return "GurQueryForm";
    }

    @RequestMapping("/insGurQuery")
    public String saveGurQuery(Model model, GurQuery gurQuery) {
        gurQueryRepo.save(gurQuery);
        model.addAttribute("msg","Query has been sent successfully.");
        return "GurQueryForm";
    }

    @RequestMapping("/getNoticeGur")
    public String redirectToNoticeGur(Model model) throws Exception {
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);  
        System.out.println(strDate);
        model.addAttribute("noticeres", noticeRepo.findByExpDate(strDate));
        return "GetNoticeGur";
    }

    @RequestMapping("/getResultGur")
    public String redirectToResultGur(@ModelAttribute("mail") String mail, String semester, Model model, SignUp signUp) {
        semester = "1";
        String stumailid = signupRepo.getStu(mail);
        System.out.println(stumailid);
        model.addAttribute("result", semOneRepo.findByEmailidAndSemester(stumailid, semester));
        return "GetResultGur";
    }

    @RequestMapping("/replies")
    public String redirectToGurQueryResponse(@ModelAttribute("mail") String mail, Model model) {
        model.addAttribute("getResponses", gurQueryRepo.findByGurEmail(mail));
        return "GurQueryResponses";
    }

    @RequestMapping("/gprofile")
    public String redirectToGProfile(@ModelAttribute("mail") String mail,Model model) {
        model.addAttribute("GurProfile", gurRepo.findByGurEmail(mail));
        return "GurProfileDash";
    }

    @RequestMapping("/editGurProfile")
    public String redirectToGeditProfile(@ModelAttribute("mail") String mail,Model model) {
        model.addAttribute("GurProfile", gurRepo.findByGurEmail(mail));
        return "EditGurProfile";
    }

    @Transactional
    @RequestMapping("/updateGurProfile")
    public String updateGuardian(@ModelAttribute("mail") String mail,@RequestParam("gurMobile") String gurMobile,@RequestParam("gurAddress") String gurAddress,@RequestParam("gurPincode") String gurPincode, Model model) {
        gurRepo.updateGurProfile(mail, gurMobile, gurAddress, gurPincode);
        return "indexGur";
    }

    @RequestMapping("/save-GurProfile")
    public String saveGurProfile(Model model,Guardian guardian) {
        gurRepo.save(guardian);
        model.addAttribute("error", "You have completed your profile. Kindly Login Again.");
        return "login";
    }

    // Guardian Module End
}