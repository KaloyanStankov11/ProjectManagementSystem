import { Component } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent {
  menuItems = [
    { label: 'Home', link: '/' },
    { label: 'Tasks', link: '/tasks' },
    { label: 'Logged Work', link: '/logged' },
    { label: 'Workers', link: '/workers' },
    { label: 'Admin Panel', link: '/manage-projects' },
  ];
}
