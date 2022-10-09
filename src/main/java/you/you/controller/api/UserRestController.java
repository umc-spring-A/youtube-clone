package you.you.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import you.you.controller.dto.user.UserSignupDto;
import you.you.service.UserService;

import javax.validation.Valid;

@RestController()
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserService userService;
    /**
     * 회원 가입
     * @Param : RegisterUserDto
     * @Response : 200(성공) or 400
     * */
    @PostMapping
    public ResponseEntity registerUser(@RequestBody @Valid UserSignupDto userDto) throws Exception {
        userService.registerUser(userDto);
        return ResponseEntity.ok().build();
    }
}
