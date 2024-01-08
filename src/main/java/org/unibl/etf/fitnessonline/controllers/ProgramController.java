package org.unibl.etf.fitnessonline.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.fitnessonline.exceptions.NotFoundException;
import org.unibl.etf.fitnessonline.models.dtos.ProgramDTO;
import org.unibl.etf.fitnessonline.models.dtos.ProgramParticipationDTO;
import org.unibl.etf.fitnessonline.models.dtos.ProgramSimpleDTO;
import org.unibl.etf.fitnessonline.models.requests.FilterRequest;
import org.unibl.etf.fitnessonline.models.requests.ParticipationRequest;
import org.unibl.etf.fitnessonline.models.requests.ProgramRequest;
import org.unibl.etf.fitnessonline.services.ProgramService;

import java.util.List;

@RestController
@RequestMapping("/api/programs")
@CrossOrigin(origins = "*")
public class ProgramController {
    private final ProgramService programService;

    public ProgramController(ProgramService service) {
        this.programService = service;
    }



    @GetMapping
    public List<ProgramSimpleDTO> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {
        return programService.findAll(page, size);
    }

    @PostMapping("/filter")
    public List<ProgramSimpleDTO> findAll(@RequestBody(required = false) FilterRequest filterRequest, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {
        return programService.findAll(filterRequest, page, size);
    }

    @GetMapping("/count")
    public long countAll() {
        return programService.countAll();
    }

    @PostMapping("/count")
    public long countAll(@RequestBody(required = false) FilterRequest filterRequest) {
        return programService.countAll(filterRequest);
    }

    @GetMapping("/{id}")
    public ProgramDTO findById(@PathVariable Integer id) throws NotFoundException {
        return programService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        programService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProgramDTO insert(@RequestBody ProgramRequest programRequest) {
        return programService.insert(programRequest);
    }

    @PutMapping("/{id}")
    public ProgramDTO update(@PathVariable Integer id, @RequestBody ProgramRequest programRequest) {
        return programService.update(id, programRequest);
    }

    @GetMapping("/{programId}/{userId}")
    public ProgramParticipationDTO checkIfParticipant(@PathVariable Integer programId, @PathVariable Integer userId) {
        return programService.checkIfParticipant(userId, programId);
    }

    @PostMapping("/add-participation")
    public void addParticipation(@RequestBody ParticipationRequest request) {
        programService.insertParticipation(request);
    }

    @GetMapping("/owner/{programId}/{userId}")
    public boolean checkIfOwner(@PathVariable Integer programId, @PathVariable Integer userId) {
        return programService.checkIfOwner(userId, programId);
    }

    @GetMapping("/current-programs/{userId}")
    public List<ProgramSimpleDTO> getCurrentProgramsByUserId(@PathVariable Integer userId) {
        return programService.getCurrentProgramsByUserId(userId);
    }

    @GetMapping("/past-programs/{userId}")
    public List<ProgramSimpleDTO> getPastProgramsByUserId(@PathVariable Integer userId) {
        return programService.getPastProgramsByUserId(userId);
    }
}
