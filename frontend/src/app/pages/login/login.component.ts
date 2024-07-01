import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {UserService} from "../../service/user.service";
import {NavbarService} from "../../service/navbar.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent  implements OnInit, OnDestroy{
  loginFormGroup: FormGroup;
  // @ts-ignore
  userRole: string

  constructor(private userService: UserService,
              private router: Router,
              private navbarService: NavbarService) {
    this.loginFormGroup = new FormGroup({
      username: new FormControl(null, Validators.required),
      password: new FormControl(null, Validators.required)
    })
  }

  ngOnInit(): void {
    this.navbarService.hide()
  }

  login() {
    if (!this.loginFormGroup.valid) {
      return
    }
    this.userService.login(this.loginFormGroup.get("username")?.value, this.loginFormGroup.get("password")?.value)
      .subscribe(data => {
        this.userRole = data.authorities.find(it => it == "MANAGER") ? "MANAGER" : "WORKER"
        this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
          this.router.navigate(['home']);
        });
      })
  }

  ngOnDestroy(): void {
    this.navbarService.display()
    if (this.userRole == "MANAGER" || this.userRole == "OWNER") {
      this.navbarService.displayManagerPanel()
    } else {
      this.navbarService.hideManagerPanel()
    }
  }
}
