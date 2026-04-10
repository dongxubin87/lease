package com.dong.lease.web.admin.controller.apartment;

import com.dong.lease.common.result.Result;
import com.dong.lease.model.entity.LeaseTerm;
import com.dong.lease.web.admin.service.LeaseTermService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Lease Term Management")
@RequestMapping("/admin/term")
@RestController
public class LeaseTermController {

    @Autowired
    private LeaseTermService service;

    @GetMapping("list")
    @Operation(summary = "Get all lease terms")
    public Result<List<LeaseTerm>> listLeaseTerm() {
        List<LeaseTerm> list = service.list();
        return Result.ok(list);
    }

    @PostMapping("saveOrUpdate")
    @Operation(summary = "Create or update a lease term")
    public Result saveOrUpdate(@RequestBody LeaseTerm leaseTerm) {
        service.saveOrUpdate(leaseTerm);
        return Result.ok();
    }

    @DeleteMapping("deleteById")
    @Operation(summary = "Delete a lease term by ID")
    public Result deleteLeaseTermById(@RequestParam Long id) {
        service.removeById(id);
        return Result.ok();
    }
}