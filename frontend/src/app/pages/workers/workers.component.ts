import { Component } from '@angular/core';

@Component({
  selector: 'app-workers',
  templateUrl: './workers.component.html',
  styleUrls: ['./workers.component.scss']
})
export class WorkersComponent {

  columnsToDisplay = ["USERNAME", "EMAIL", "PHONE", "ACTIONS"]
  workers = [
    {username: "hakiri", email: "hakiri@mail.com", phone: "1111111"},
    {username: "gorbet", email: "gorbet@mail.com", phone: "1111111"},
    {username: "peter", email: "peter@mail.com", phone: "1111111"},
    {username: "john", email: "john@mail.com", phone: "1111111"},
    {username: "felipa", email: "felipa@mail.com", phone: "1111111"},
  ]
}
