package com.siferga.webapp.controller;

import com.siferga.webapp.model.Knowledge;
import com.siferga.webapp.model.Project;
import com.siferga.webapp.service.CustomUserDetailsService;
import com.siferga.webapp.service.KnowledgeServiceImpl;
import com.siferga.webapp.service.ProjectServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class KnowledgeController {

    private final KnowledgeServiceImpl knowledgeServiceImpl;
    private final ProjectServiceImpl projectServiceImpl;
    private final CustomUserDetailsService customUserDetailsService;

    /*************************   ADD KNOWLEDGE  *****************************/

    @GetMapping("/addKnowledge")
    public ModelAndView showAddKnowledgeForm(Model model) {
        model.addAttribute("allProjects",projectServiceImpl.findAllProjects());
        return new ModelAndView("knowledge/addKnowledge", "knowledge", new Knowledge());
    }

    @PostMapping("/addKnowledge")
    public ModelAndView addNewKnowledge(@RequestParam("file") MultipartFile file,
                                        @RequestParam("projectId") Long projectId) {
        // Register the new knowledge
        Long userId = customUserDetailsService.actualUser().getId();
        knowledgeServiceImpl.registerKnowledge(userId, projectId, file);
        return new ModelAndView("knowledge/knowledgeList");

//        // Redirect to the knowledge list or success page
//        return new ModelAndView("redirect:/knowledgeList");

    }

    /*************************   KNOWLEDGE LIST   *****************************/

    @GetMapping("/knowledgeList")
    public ModelAndView showKnowledgeList(Model model) {
        List<Knowledge> knowledges = knowledgeServiceImpl.findAllKnowledges();
        return new ModelAndView("knowledge/knowledgeList", "knowledge", knowledges);
    }

    @PostMapping("/knowledgeList")
    public ModelAndView showKnowledgeList(@ModelAttribute Knowledge knowledge) {
        List<Knowledge> knowledges = knowledgeServiceImpl.findAllKnowledges();
        ModelAndView modelAndView = new ModelAndView("knowledge/knowledgeList");
        modelAndView.addObject("knowledges", knowledges);
        modelAndView.addObject("knowledge", new Knowledge());
        return modelAndView;
    }

    @GetMapping("/findAllKnowledge")
    public ResponseEntity<List<Knowledge>> getAllKnowledge() {
        List<Knowledge> knowledges = knowledgeServiceImpl.findAllKnowledges();
        return ResponseEntity.ok(knowledges);
    }

    /***************************   FIND A KNOWLEDGE   ********************************/

    @PostMapping("/findKnowledgeById")
    public ResponseEntity<byte[]> getKnowledgeById(@RequestParam String id) {
        return this.knowledgeServiceImpl.findKnowledgeById(id);
    }


    /*************************   DELETE A KNOWLEDGE  *****************************/

    @GetMapping("/deleteKnowledge/{id}")
    public ModelAndView showDeleteKnowledgeForm(@PathVariable("id") Long id) {
        return new ModelAndView("knowledge/deleteKnowledge", "knowledge", knowledgeServiceImpl.findKnowledgeById(String.valueOf(id)));
    }

    @PostMapping("/deleteKnowledge/{id}")
    public ModelAndView deleteKnowledge(@PathVariable("id") Long id) {
        knowledgeServiceImpl.deleteKnowledge(String.valueOf(id));
        return new ModelAndView("knowledge/knowledgeList");
    }
//    @PostMapping("/deleteKnowledge/{id}")
//    public String deleteKnowledge(@PathVariable("id") Long id) {
//        knowledgeServiceImpl.deleteKnowledge(String.valueOf(id));
//        return "redirect:/knowledgeList"; // Redirection après suppression

    /*************************   KNOWLEDGE DETAILS   *****************************/
    @GetMapping("/knowledgeDetails/{id}")
    public String viewKnowledgeDetails(@PathVariable("id") String id, Model model) {
        ResponseEntity<byte[]> knowledge = knowledgeServiceImpl.findKnowledgeById(id);
        if (knowledge != null) {
            model.addAttribute("knowledge", knowledge);
            return "knowledge/knowledgeDetails";  // Retourne la vue des détails du collaborateur
        }else {
            return "redirect:knowledge/knowledgeList";
        }
    }
}
