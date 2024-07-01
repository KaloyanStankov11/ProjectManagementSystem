import {Component, OnInit} from '@angular/core';
import {Task} from "../../model/Task";
import {LoggedWork} from "../../model/LoggedWork";
import {TaskService} from "../../service/task.service";
import {LoggedService} from "../../service/logged.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{
  tasks: Task[]
  loggedWork: LoggedWork[]
  loggedWorkTableColumns = ["TASK", "TIME", "DATE"]

  constructor(private taskService: TaskService, private loggedService: LoggedService) {
  }
  ngOnInit(): void {
    this.taskService.getUserTasks().subscribe(data => {
      this.tasks = data
    })
    this.loggedService.getUserLastWeekLoggedWork().subscribe(data =>{
      this.loggedWork = data
    })
  }
}
