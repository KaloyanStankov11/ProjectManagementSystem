import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AppUser} from "../../model/AppUser";
import {UserService} from "../../service/user.service";
import {Subscription} from "rxjs";
import {NavbarService} from "../../service/navbar.service";

@Component({
  selector: 'app-workers',
  templateUrl: './workers.component.html',
  styleUrls: ['./workers.component.scss']
})
export class WorkersComponent implements OnInit{

  columnsToDisplay = ["USERNAME", "EMAIL", "ROLE" ,"PHONE", "ACTIONS"]
  workers: AppUser[]
  isManager: boolean
  subscribers: Subscription[] = []

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService, private navBarService: NavbarService) {
  }
  ngOnInit(): void {
    this.workers = this.route.snapshot.data["users"]
    this.subscribers.push(this.navBarService.showManagerPanel.subscribe((value) => {
      this.isManager = value
    }))
  }

  goToAddWorker() {
    this.router.navigate(["add-worker"])
  }

  deleteWorker(worker: AppUser) {
    this.userService.deleteUser(worker.username).subscribe(data =>{
      this.workers = data
    })
  }
}
