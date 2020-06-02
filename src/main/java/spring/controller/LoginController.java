package spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.LoginService.Login_service;
import spring.model.ClassName;
import spring.model.GlobalResponse;
import spring.model.ImportModal;
import spring.model.RegistrationRequest;
import spring.model.Section;
import spring.model.Studentlisting;
import spring.model.Userlogin;

@RestController
public class LoginController {

	@Autowired
	private Login_service login_service;

	/*---get all books---*/
	@GetMapping("/v1/users")
	public ResponseEntity<List<Userlogin>> list() {
		GlobalResponse globalResponse = new GlobalResponse();
		List<Userlogin> userlogin = login_service.list();
		globalResponse.setStatus("success");
		globalResponse.setData(userlogin);
		globalResponse.setStatus_code(200);
		globalResponse.setMessage("user successfull logged in!");

		return ResponseEntity.ok().body(userlogin);
	}

	@GetMapping("/v1/showclass")
	public ResponseEntity<GlobalResponse> showclass() {
		List<ClassName> classModels = login_service.showclass();
		GlobalResponse globalResponse = new GlobalResponse();
		globalResponse.setStatus("success");
		globalResponse.setData(classModels);
		globalResponse.setStatus_code(200);
		globalResponse.setMessage("user successfull logged in!");

		return ResponseEntity.ok().body(globalResponse);
	}

	@GetMapping("/v1/showsection")
	public ResponseEntity<GlobalResponse> showsection() {

		List<?> sectionModels = login_service.showsection();

		GlobalResponse globalResponse = new GlobalResponse();
		globalResponse.setStatus("success");
		globalResponse.setData(sectionModels);
		globalResponse.setStatus_code(200);
		globalResponse.setMessage("user successfull logged in!");

		return ResponseEntity.ok().body(globalResponse);
	}

	/*---Add user---*/
	@PostMapping("/v1/adduser")
	public ResponseEntity<String> save(@RequestBody Userlogin userlogin) {
		String id = null;
		String res = null;
		try {
			id = login_service.save(userlogin);
		} catch (Exception e) {
			res = e.getMessage().toString();
		}
		return ResponseEntity.ok().body("New user created with id :" + id + "respose: " + res);
	}

	// add class
	@PostMapping("/v1/addclass")
	public GlobalResponse addclass(@RequestBody ClassName className) {
		ClassName id = null;
		GlobalResponse globalResponse = new GlobalResponse();
		try {
			id = login_service.addClass(className);
		} catch (Exception e) {
			globalResponse.setStatus("fail");
			globalResponse.setData(e.getMessage());
			globalResponse.setStatus_code(500);
			globalResponse.setMessage("failed to add class");
		}
		if (id != null) {
			globalResponse.setStatus("success");
			globalResponse.setData(id);
			globalResponse.setStatus_code(200);
			globalResponse.setMessage("class added succefully");

		} else {
			globalResponse.setStatus("fail");
			globalResponse.setData("data already exist!");
			globalResponse.setStatus_code(401);
			globalResponse.setMessage("class already present");
		}

		return globalResponse;
	}

	// add section
	@PostMapping("/v1/addsection")
	public GlobalResponse addsection(@RequestBody Section section) {
		Section sec = null;

		GlobalResponse globalResponse = new GlobalResponse();
		try {
			sec = login_service.addSection(section);
		} catch (Exception e) {
			globalResponse.setStatus("fail");
			globalResponse.setData(e.getMessage());
			globalResponse.setStatus_code(500);
			globalResponse.setMessage("failed to add section");
		}
		if (sec != null) {
			globalResponse.setStatus("success");
			globalResponse.setData(sec);
			globalResponse.setStatus_code(200);
			globalResponse.setMessage("section added successfully!");

		} else {

			globalResponse.setStatus("fail");
			globalResponse.setData(section);
			globalResponse.setStatus_code(401);
			globalResponse.setMessage("section already present");
		}
		return globalResponse;
	}

	/*---check user---*/
	@GetMapping("/v1/checkuser")
	public ResponseEntity<GlobalResponse> checkuser(@RequestBody Userlogin userlogin) {
		Userlogin user = null;
		GlobalResponse globalResponse = new GlobalResponse();

		try {
			user = login_service.checkuser(userlogin.getEmail().toString(), userlogin.getPassword().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			globalResponse.setStatus("fail");
			globalResponse.setStatus_code(500);
			globalResponse.setMessage(e.getMessage().toString());

		}

		if (user != null) {
			user.setPassword(null);
			globalResponse.setStatus("success");
			globalResponse.setData(user);
			globalResponse.setStatus_code(200);
			globalResponse.setMessage("user successfull logged in!");
		} else {
			globalResponse.setStatus("fail");
			globalResponse.setStatus_code(401);
			globalResponse.setMessage("login unsuccssful!");
		}
		return ResponseEntity.ok().body(globalResponse);
	}

	/*---Delete a book by id---*/
	@DeleteMapping("/v1/user/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		String ms;
		try {
			login_service.delete(id);
			ms = "deleted successfully.";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ms = e.getMessage();
		}
		return ResponseEntity.ok().body(ms);
	}

	/*---Delete a book by id---*/
	@PostMapping("/v1/deletesection/{sec}")
	public GlobalResponse deletesection(@PathVariable("sec") long sec) {

		String id = null;
		GlobalResponse globalResponse = new GlobalResponse();
		try {
			id = login_service.deletesection(sec);

		} catch (Exception e) {
			globalResponse.setStatus("fail");
			globalResponse.setData(e.getMessage());
			globalResponse.setStatus_code(500);
			globalResponse.setMessage("failed to delete section");
		}
		if (id != null) {
			globalResponse.setStatus("success");
			globalResponse.setData(id);
			globalResponse.setStatus_code(200);
			globalResponse.setMessage("section deleted successfully!");
		} else {
			globalResponse.setStatus("fail");
			globalResponse.setData("null");
			globalResponse.setStatus_code(401);
			globalResponse.setMessage("section not found");
		}
		return globalResponse;

	}

	@PostMapping("/v1/deleteclass/{cls}")
	public GlobalResponse deleteclass(@PathVariable("cls") long cls) {

		String id = null;
		GlobalResponse globalResponse = new GlobalResponse();
		try {
			id = login_service.deleteclass(cls);

		} catch (Exception e) {
			globalResponse.setStatus("fail");
			globalResponse.setData(e.getMessage());
			globalResponse.setStatus_code(500);
			globalResponse.setMessage("failed to delete class");
		}
		if (id != null) {
			globalResponse.setStatus("success");
			globalResponse.setData(id);
			globalResponse.setStatus_code(200);
			globalResponse.setMessage("class deleted successfully!");
		} else {
			globalResponse.setStatus("fail");
			globalResponse.setData("null");
			globalResponse.setStatus_code(401);
			globalResponse.setMessage("class not found");
		}
		return globalResponse;

	}

	@PostMapping("/v1/updateclass/{classid}")
	public GlobalResponse update(@PathVariable("classid") long classid, @RequestBody ClassName className) {

		GlobalResponse globalResponse = new GlobalResponse();
		try {
			login_service.updateclass(classid, className);
			globalResponse.setStatus("success");
			globalResponse.setData(null);
			globalResponse.setStatus_code(200);
			globalResponse.setMessage("class updated successfully!");

		} catch (Exception e) {
			globalResponse.setStatus("fail");
			globalResponse.setData(e.getMessage());
			globalResponse.setStatus_code(500);
			globalResponse.setMessage("failed to update class");
		}

		return globalResponse;
	}

	@PostMapping("/v1/updatesection/{sectionid}")
	public GlobalResponse update(@PathVariable("sectionid") long sectionid, @RequestBody Section section) {

		GlobalResponse globalResponse = new GlobalResponse();
		try {
			login_service.updatesection(sectionid, section);
			globalResponse.setStatus("success");
			globalResponse.setData(null);
			globalResponse.setStatus_code(200);
			globalResponse.setMessage("section updated successfully!");

		} catch (Exception e) {
			globalResponse.setStatus("fail");
			globalResponse.setData(e.getMessage());
			globalResponse.setStatus_code(500);
			globalResponse.setMessage("failed to update section");
		}
		return globalResponse;
	}

	// registration
	@PostMapping("/v1/registerstudent")
	public GlobalResponse registerstudent(@RequestBody RegistrationRequest rr) {
		String id = null;
		GlobalResponse globalResponse = new GlobalResponse();
		try {
			id = login_service.createUser(rr);
			globalResponse.setStatus("success");
			globalResponse.setData(id);
			globalResponse.setStatus_code(200);
			globalResponse.setMessage("registered succefully");

		} catch (Exception e) {
			globalResponse.setStatus("fail");
			globalResponse.setData(e.getMessage());
			globalResponse.setStatus_code(500);
			globalResponse.setMessage("failed to register");
		}

		return globalResponse;
	}

	@GetMapping("/v1/showstudents/page/{pagenumber}/{pagesize}")
	public ResponseEntity<Studentlisting> showstudents(@PathVariable("pagenumber") long pagenumber,
			@PathVariable("pagesize") long pagesize,
			@RequestParam(name = "searchval", required = false) String searchval) {
		List<?> students = login_service.showstudents(pagenumber, pagesize, searchval);
		Studentlisting studentlisting = new Studentlisting();
		studentlisting.setStatus("success");
		studentlisting.setDraw(login_service.drawpage());
		studentlisting.setRecordsFiltered(login_service.filterrecord(searchval));
		studentlisting.setRecordsTotal(login_service.totalrecord());
		studentlisting.setData(students);
		studentlisting.setStatus_code(200);
		studentlisting.setMessage("user successfull logged in!");

		return ResponseEntity.ok().body(studentlisting);
	}

	@PostMapping("/import")
	public GlobalResponse mapReapExcelDatatoDB(@RequestBody RegistrationRequest[] reapExcelDataFile) throws IOException {

		List<RegistrationRequest> tempStudentList = null;
		try {
			tempStudentList = new ArrayList<RegistrationRequest>();
			for(RegistrationRequest im:reapExcelDataFile)
			{
				tempStudentList.add(im);
				System.out.println(im.getStudent_first_name());
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		@SuppressWarnings("resource")
//		XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
//		XSSFSheet worksheet = workbook.getSheetAt(0);
//
//		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
//			ImportModal tempStudent = new ImportModal();
//			XSSFRow row = worksheet.getRow(i);
//			
//			tempStudent.setId((int) row.getCell(0).getNumericCellValue());
//			tempStudent.setName(row.getCell(1).getStringCellValue());
//			tempStudent.setFathername(row.getCell(2).getStringCellValue());
//			tempStudent.setMothername(row.getCell(3).getStringCellValue());
//			tempStudent.setPhone(row.getCell(4).getStringCellValue());
//			tempStudentList.add(tempStudent);
//		}
//		
		String sec = null;

		GlobalResponse globalResponse = new GlobalResponse();
		try {
			sec = login_service.importexcel(tempStudentList);
		} catch (Exception e) {
			globalResponse.setStatus("fail");
			globalResponse.setData(e.getMessage());
			globalResponse.setStatus_code(500);
			globalResponse.setMessage("failed to add section");
		}
		if (sec != null) {
			globalResponse.setStatus("success");
			globalResponse.setData(sec);
			globalResponse.setStatus_code(200);
			globalResponse.setMessage("section added successfully!");

		} else {

			globalResponse.setStatus("fail");
			globalResponse.setData(sec);
			globalResponse.setStatus_code(401);
			globalResponse.setMessage("section already present");
		}
		
		return globalResponse;
		
	}

//	@RequestMapping(value = "/fileupload", headers = ("content-type=multipart/*"), method = RequestMethod.POST)
//	public ResponseEntity<FileInfo> upload(@RequestParam("file") MultipartFile inputFile) {
//		FileInfo fileInfo = new FileInfo();
//		HttpHeaders headers = new HttpHeaders();
//		if (!inputFile.isEmpty()) {
//			try {
//				String originalFilename = inputFile.getOriginalFilename();
//				File destinationFile = new File(
//						context.getRealPath("/WEB-INF/uploaded") + File.separator + originalFilename);
//				destinationFile.createNewFile();
//				inputFile.transferTo(destinationFile);
//				fileInfo.setFileName(destinationFile.getPath());
//				fileInfo.setFileSize(inputFile.getSize());
//				headers.add("File Uploaded Successfully - ", originalFilename);
//				return new ResponseEntity<FileInfo>(fileInfo, headers, HttpStatus.OK);
//			} catch (Exception e) {
//				return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
//			}
//		} else {
//			return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
//		}
//	}

//	/*---Add new book---*/
//	@PostMapping("/book")
//	public ResponseEntity<?> save(@RequestBody Book book) {
//		long id = bookService.save(book);
//
//		return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
//	}

//	/*---Get a book by id---*/
//	@GetMapping("/book/{id}")
//	public ResponseEntity<Book> get(@PathVariable("id") long id) {
//		Book book = bookService.get(id);
//		return ResponseEntity.ok().body(book);
//	}
//
//	/*---get all books---*/
//	@GetMapping("/book")
//	public ResponseEntity<List<Book>> list() {
//		List<Book> books = bookService.list();
//		return ResponseEntity.ok().body(books);
//	}
//
//	/*---Update a book by id---*/
//	@PutMapping("/book/{id}")
//	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Book book) {
//		bookService.update(id, book);
//		return ResponseEntity.ok().body("Book has been updated successfully.");
//	}
//
//	/*---Delete a book by id---*/
//	@DeleteMapping("/book/{id}")
//	public ResponseEntity<?> delete(@PathVariable("id") long id) {
//		bookService.delete(id);
//		return ResponseEntity.ok().body("Book has been deleted successfully.");
//	}

}