import { Component } from '@angular/core';
import {Task} from "../../model/Task";
import {LoggedWork} from "../../model/LoggedWork";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  tasks: Task[]
  loggedWork: LoggedWork[]
  loggedWorkTableColumns = ["TASK", "TIME", "DATE"]
}
