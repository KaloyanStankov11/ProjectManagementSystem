import {Component, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {FormBuilder, FormGroup} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../../service/user.service";
import {AppUser, RegisterUserRequest} from "../../../model/AppUser";
import {Project} from "../../../model/Project";

@Component({
  selector: 'app-add-worker',
  templateUrl: './add-worker.component.html',
  styleUrls: ['./add-worker.component.scss']
})
export class AddWorkerComponent implements OnInit{

  userFormGroup: FormGroup;
  subscribers: Subscription[] = [];
  projects: Project[]

  constructor(private router: Router, private route: ActivatedRoute, private fb: FormBuilder, private userService: UserService) {
  }

  ngOnInit(): void {
    this.projects = this.route.snapshot.data["projects"]
    this.userFormGroup = this.fb.group({
      username: this.fb.control(null),
      email: this.fb.control(null),
      phoneNumber: this.fb.control(null),
      project: this.fb.control(null),
      isManager: this.fb.control(false)
    })
  }

  registerUser() {
    if (!this.userFormGroup.valid) {
      return
    }
    const userDetails = new AppUser(
      this.userFormGroup.get("username")?.value,
      this.userFormGroup.get("email")?.value,
      this.userFormGroup.get("password")?.value,
      this.userFormGroup.get("phoneNumber")?.value,
      null, null
    )
    this.subscribers.push(this.userService.createUser(new RegisterUserRequest(userDetails, this.userFormGroup.get("isManager")?.value)).subscribe(_ => {
      this.router.navigate(["workers"])
    }))
  }

  navigateBack() {
    this.router.navigate(["workers"])
  }
}
