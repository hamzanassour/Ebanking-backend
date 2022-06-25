package com.ensapay.ebanking.controller;


import com.ensapay.ebanking.entities.Agent;
import com.ensapay.ebanking.services.AgentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Agent")
public class AgentController {

    private final AgentService agentService;


    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping("/agents")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Agent>  findAllAgents()
    {
        return  agentService.findAllAgents();
    }

    @GetMapping("/agent/{username}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Agent getAgentByUsername(@PathVariable("username") String username)
    {
        return  agentService.findAgentByUsername(username);
    }

    @PostMapping("/addAgent")
    @ResponseStatus(HttpStatus.CREATED)
    public void AddAgent(@RequestBody  Agent agent)
    {
        agentService.AddAgent(agent);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateAgent(@PathVariable("id") Long id, @RequestBody Agent agent )
    {
        agentService.updateAgent(id,agent);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAgent(@PathVariable("id") Long id)
    {
        agentService.deleteAgent(id);
    }




}
