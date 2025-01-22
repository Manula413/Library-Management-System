package com.manula413.controller;

import com.manula413.model.Member;
import com.manula413.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    // Get all members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Get member by ID
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            return new ResponseEntity<>(member.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add a new member
    @PostMapping
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        Member savedMember = memberRepository.save(member);
        return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
    }

    // Update an existing member
    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member member) {
        if (memberRepository.existsById(id)) {
            member.setId(id);
            Member updatedMember = memberRepository.save(member);
            return new ResponseEntity<>(updatedMember, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a member
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

