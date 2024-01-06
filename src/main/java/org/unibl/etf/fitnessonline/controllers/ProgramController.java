package org.unibl.etf.fitnessonline.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.fitnessonline.exceptions.NotFoundException;
import org.unibl.etf.fitnessonline.models.dtos.ProgramDTO;
import org.unibl.etf.fitnessonline.models.dtos.ProgramSimpleDTO;
import org.unibl.etf.fitnessonline.models.requests.FilterRequest;
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
//
//    @GetMapping
//    List<ProgramSimpleDTO> findAll() {
//        return programService.findAll();
//    }

    @GetMapping
    public List<ProgramSimpleDTO> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return programService.findAll(page, size);
    }

    @PostMapping("/filter")
    public List<ProgramSimpleDTO> findAll(@RequestBody(required = false) FilterRequest filterRequest, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
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
}
