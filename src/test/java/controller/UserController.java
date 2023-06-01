package controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/all")
//    public ResponseEntity <List<User>> getAll(){
//        return ResponseEntity.ok(userRepository.findAll());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getById(@PathVariable Long id) {
//        return userRepository.findById(id)
//                .map(response -> ResponseEntity.ok(response))
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<UserLogin> login(@RequestBody Optional<UserLogin> userLogin) {
//        return userService.authenticateUser(userLogin)
//                .map(response -> ResponseEntity.ok(response))
//                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<User> postUsuario(@Valid @RequestBody User user) {
//
//        return userService.registerUser(user)
//                .map(response -> ResponseEntity.status(HttpStatus.CREATED).body(response))
//                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
//
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<User> putUsuario(@Valid @RequestBody User user) {
//        return userService.updateUser(user)
//                .map(response -> ResponseEntity.status(HttpStatus.OK).body(response))
//                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
//    }

}
