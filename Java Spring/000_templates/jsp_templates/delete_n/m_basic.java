

// <!-- one to many remove association! -->

    // <!-- in the service -->
	public void removeFromDorm(Student s) {
		s.setDorm(null);
		studentRepo.save(s);
	}

    // <!-- in the jsp -->
	<td><a href="/students/${student.id}/update">Delete</a></td>


    // <!-- in the controller -->
    @GetMapping("/students/{id}/update")
	public String removeStudent(@PathVariable("id") Long id){
		Student oneStudent = studentServ.findById(id);
		studentServ.removeFromDorm(oneStudent);
		return "redirect:/dorms/";
	}





	

	// MANY TO MANY
	
	// In the controller
	
	@PostMapping("/classes/{studentId}/update")
	public String removeClass(@PathVariable("studentId") Long studentId, @RequestParam(name="classId") Long classId) {
		Student oneStudent = studentServ.findById(studentId);
		Classes oneClass = classServ.findById(classId);
		List<Student> studentList = oneClass.getStudentsInClass();
		studentList.remove(oneStudent);
		oneClass.setStudentsInClass(studentList);
		classServ.create(oneClass);
		return "redirect:/students/" + studentId;
	}

	// IN the JSP


					    	<form action="/classes/${oneStudent.id}/update" method="POST">
							<input type="hidden" name="classId" value="${s.id}"/>					    	
					    	<button>Drop</button>
					    	</form>
