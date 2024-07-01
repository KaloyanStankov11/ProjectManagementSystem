import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Task} from "../../../model/Task";
import {LoggedWork} from "../../../model/LoggedWork";
import {TaskService} from "../../../service/task.service";

@Component({
  selector: 'app-task-overview',
  templateUrl: './task-overview.component.html',
  styleUrls: ['./task-overview.component.scss']
})
export class TaskOverviewComponent implements OnInit{

  taskFormGroup: FormGroup
  task: Task
  loggedWork: FormControl = new FormControl()

  constructor(private fb: FormBuilder, private route: ActivatedRoute, private router: Router, private taskService: TaskService) {
    this.task = this.router.getCurrentNavigation()?.extras.state?.['task'];
    this.taskFormGroup = fb.group({
      title: fb.control(this.task.caption),
      description: fb.control(this.task.description),
      assignee: fb.control(this.task.assignee.username),
      creator: fb.control(this.task.creator),
      project: fb.control(this.task.project),
      estimationTime: fb.control(this.task.estimatedTime.number + " " + this.task.estimatedTime.unit),
    })
  }
  ngOnInit(): void {
    this.taskService.getTaskLoggedWork(this.task.id).subscribe(data =>{
      this.loggedWork.setValue(data)
    })
  }

}
