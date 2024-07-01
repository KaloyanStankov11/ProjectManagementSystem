import {Component, OnInit} from '@angular/core';
import {NavbarService} from "../../service/navbar.service";
import {Subscriber, Subscription} from "rxjs";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent{

  subscribers: Subscription[] = []
  showNavBar: boolean
  managerPanelLink = "/manage-projects"
  showManagerPanel: boolean
  constructor(public navBarService: NavbarService) {
    this.subscribers.push(this.navBarService.showNavBar.subscribe((value) => {
      this.showNavBar = value
    }))
    this.subscribers.push(this.navBarService.showManagerPanel.subscribe((value) => {
      this.showManagerPanel = value
    }))
  }

  menuItems = [
    { label: 'Home', link: '/home' },
    { label: 'Tasks', link: '/tasks' },
    { label: 'Logged Work', link: '/logged' },
    { label: 'Workers', link: '/workers' },
  ];
}
