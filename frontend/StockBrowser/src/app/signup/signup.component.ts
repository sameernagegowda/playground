import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../gen';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signupForm: FormGroup;
  message: string;

  get nameControl(): FormControl {
    return this.signupForm.get("name") as FormControl;
  }

  get emailControl(): FormControl {
    return this.signupForm.get("email") as FormControl;
  }

  get passwordControl(): FormControl {
    return this.signupForm.get("password") as FormControl;
  }

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.signupForm = new FormGroup({
      name: new FormControl(null, [Validators.required]),
      email: new FormControl(null, [Validators.required, Validators.email]),
      password: new FormControl(null, [Validators.required])
    });
  }

  doSignup() {
    this.message = "";
    if (this.signupForm.valid) {
      let name = this.signupForm.get('name')?.value;
      let email = this.signupForm.get('email')?.value;
      let password = this.signupForm.get('password')?.value;
      this.userService.createUser(
        {
          name: name,
          email: email,
          password: password
        }
      ).toPromise()
        .then(user => {
          this.router.navigate(['/login']);
        })
        .catch(error => {
          this.message = "failed to signup [ " + error.message + " ]";
        })
    }
  }

}
