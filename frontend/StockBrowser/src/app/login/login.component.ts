import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../gen';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  message: string;

  get emailControl(): FormControl {
    return this.loginForm.get("email") as FormControl;
  }

  get passwordControl(): FormControl {
    return this.loginForm.get("password") as FormControl;
  }

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      email: new FormControl(null, [Validators.required, Validators.email]),
      password: new FormControl(null, [Validators.required])
    });
  }

  doLogin() {
    this.message = "";
    if (this.loginForm.valid) {
      let email = this.loginForm.get('email')?.value;
      let password = this.loginForm.get('password')?.value;
      this.userService.login(email, password).toPromise()
        .then(user => {
          this.router.navigate(['/home']);
        })
        .catch(error => {
          this.message = "failed to login [ " + error.message + " ]";
        })
    }
  }
}
