package com.gudyna;

import com.gudyna.model.File;
import com.gudyna.model.Member;
import com.gudyna.model.validation.FileValidator;
import com.gudyna.model.validation.MemberValidator;
import com.gudyna.service.ServiceMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MainController
{

    @Autowired
    private MemberValidator memberValidator;

    @Autowired
    private FileValidator fileValidator;

    @Autowired
    private ServiceMock serviceMock;

    @InitBinder("member")
    protected void initMemberBinder(final WebDataBinder binder)
    {
       binder.setValidator(memberValidator);
    }

    @InitBinder("file")
    protected void initFileBinder(final WebDataBinder binder)
    {
        binder.setValidator(fileValidator);
    }

    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void sayHelloPath(ModelMap model)
    {
        System.out.print("Not_found");
    }

    @RequestMapping(value = "/geterror", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void sayHelloPath()
    {
        System.out.print("Exception");
        throw new IllegalArgumentException("my error");
    }

    @RequestMapping(value = "/hello/{name}/{surname}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sayHelloPath(@PathVariable String name, @PathVariable String surname, ModelMap model)
    {
        serviceMock.deleteMember(name, surname);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET, params = { "name", "surname" })
    @ResponseStatus(HttpStatus.CREATED)
    public String sayHelloQuery(@RequestParam String name, @RequestParam String surname, ModelMap model)
    {
        serviceMock.saveMember(name, surname);
        model.addAttribute("name", name);
        model.addAttribute("surname", surname);
        return "member/hello";
    }

    @RequestMapping(value = "/addMember", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String sayHelloForm(@ModelAttribute @Valid Member member, BindingResult result, ModelMap model)
    {
        if (result.hasErrors())
        {
            return "addMember";
        }
        model.addAttribute("name", member.getName());
        model.addAttribute("surname", member.getSurname());
        return "member/hello";
    }

    @RequestMapping(value = "/member")
    @ResponseStatus(HttpStatus.CONTINUE)
    public ModelAndView simple()
    {
        return new ModelAndView("member/addMember", "member", new Member());
    }

    @RequestMapping(value = "/allMembers")
    @ResponseStatus(HttpStatus.CONTINUE)
    public String deleteAllMembers()
    {
        serviceMock.deleteAllMembers();
        return "member/deleted";
    }

    @RequestMapping(value = "/file")
    public String formForFileUpload(Model model)
    {
        model.addAttribute("file", new File());
        return "file/uploadFile";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllExceptions(Exception ex)
    {
        return new ModelAndView("error", "message", ex.getMessage());
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String uploadFile(@ModelAttribute @Validated File file, BindingResult result, ModelMap model)
    {
        if (result.hasErrors())
        {
            throw new IllegalArgumentException("File wasn't chosen");
        }

        model.addAttribute("size", file.getFile().getSize());
        return "file/fileUploadSuccess";
    }

}
