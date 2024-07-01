import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-manage-projects',
  templateUrl: './manage-projects.component.html',
  styleUrls: ['./manage-projects.component.scss']
})
export class ManageProjectsComponent {

  constructor(private router: Router) {
  }
  goToUsersPage() {
    this.router.navigate(["/workers"])
  }
}
