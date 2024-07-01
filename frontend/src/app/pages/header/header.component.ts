import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {NavbarService} from "../../service/navbar.service";
import {UserService} from "../../service/user.service";
import {Subscription} from "rxjs";
import {FormControl} from "@angular/forms";
import {ProjectService} from "../../service/project.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit{
  showNavbar: boolean
  subscription: Subscription[] = []
  projects: string[]
  selectedProject: FormControl = new FormControl

  constructor(private router: Router, private navBarService: NavbarService, private userService: UserService, private projectService: ProjectService) {

    this.subscription.push(this.selectedProject.valueChanges.subscribe(value => {
      this.projectService.setSelectedProject(value)
    }))
  }

  ngOnInit(): void {
    this.subscription.push(
      this.navBarService.showNavBar.subscribe((value) => {
        this.showNavbar = value
        if(value){
          this.projectService.getAllProjects().subscribe(data =>{
            this.projects = data.map(it => it.projectName)
            this.selectedProject.setValue(this.projects[1])
          })
        }
      })
    )
  }

  viewProfile() {
    this.router.navigate(['profile'])
  }

  ngOnDestroy(): void {
    this.subscription.forEach(it => it.unsubscribe())
  }

  logOut() {
    this.userService.logOut()
    this.router.navigate(['login'])
  }



}
