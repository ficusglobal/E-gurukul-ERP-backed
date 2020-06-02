package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.LoginService.Login_service;
import spring.model.Userlogin;


@RestController
public class LoginController { 

	@Autowired
	private Login_service login_service;
	

	
	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}
	
	/*---get all books---*/
	   @GetMapping("/users")
	   public ResponseEntity<List<Userlogin>> list() {
	      List<Userlogin> userlogin = login_service.list();
	      return ResponseEntity.ok().body(userlogin);
	   }

	
	/*---Add user---*/
	@PostMapping("/adduser")
	public ResponseEntity<String> save(@RequestBody Userlogin userlogin) {
	String id = null;
	String res = null;
	try {
		id = login_service.save(userlogin);
	} catch (Exception e) {
		res=e.getMessage().toString();
	}
	return ResponseEntity.ok().body("New user created with id :" + id+"respose: "+res);
	}
	
	/*---check user---*/
	@GetMapping("/checkuser")
	public ResponseEntity<String> checkuser(@RequestBody Userlogin userlogin) {
		boolean id = false;
		String s=null;
		try {
			id = login_service.checkuser(userlogin.getEmail().toString(),userlogin.getPassword().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			s=e.toString();
		}
		return ResponseEntity.ok().body(" :" + id +"  :"+s);
		}
	

	   /*---Delete a book by id---*/
	   @DeleteMapping("/user/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	      login_service.delete(id);
	      return ResponseEntity.ok().body("deleted successfully.");
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