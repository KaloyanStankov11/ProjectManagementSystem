import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Task, TaskStatus} from "../../../model/Task";
import {TaskService} from "../../../service/task.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AppUser} from "../../../model/AppUser";
import {Project} from "../../../model/Project";
import {TimeMeasure} from "../../../model/TimeMeasure";

@Component({
  selector: 'app-create-task',
  templateUrl: './create-task.component.html',
  styleUrls: ['./create-task.component.scss']
})
export class CreateTaskComponent implements OnInit{

  taskFormGroup: FormGroup
  users: AppUser[]
  projects: Project[]
  isEditMode: boolean
  taskToEdit: Task
  taskStatuses = [TaskStatus.UNASSIGNED, TaskStatus.IN_PROGRESS, TaskStatus.DONE, TaskStatus.REJECTED]

  constructor(private fb: FormBuilder, private taskService: TaskService, private router: Router, private route: ActivatedRoute) {
    this.isEditMode = this.router.getCurrentNavigation()?.extras.state?.['edit'];
    this.taskToEdit = this.router.getCurrentNavigation()?.extras.state?.['task'];
    this.taskFormGroup = fb.group({
      title: fb.control(""),
      description: fb.control(""),
      assignee: fb.control(""),
      project: fb.control(""),
      estimationTime: fb.control(""),
      taskStatus: fb.control("")
    })
  }
  ngOnInit(): void {

    if(this.isEditMode){
      this.taskFormGroup.get("title")?.setValue(this.taskToEdit.caption)
      this.taskFormGroup.get("description")?.setValue(this.taskToEdit.description)
      this.taskFormGroup.get("assignee")?.setValue(this.taskToEdit.assignee)
      this.taskFormGroup.get("project")?.setValue(this.taskToEdit.project)
      this.taskFormGroup.get("estimationTime")?.setValue(this.taskToEdit.estimatedTime.number + " " + this.taskToEdit.estimatedTime.unit)
      this.taskFormGroup.get("taskStatus")?.setValue(this.taskToEdit.taskStatus)
    }
    this.users = this.route.snapshot.data["users"]
    this.projects = this.route.snapshot.data["projects"]
  }

  createTask(){
    if(!this.isEditMode) {
      const newTask = new Task(
        this.taskFormGroup.get("title")?.value,
        this.taskFormGroup.get("description")?.value,
        this.taskFormGroup.get("assignee")?.value,
        this.taskFormGroup.get("project")?.value,
        this.getStatus(),
        this.createTimeMeasure(),
      )
      this.taskService.createTask(newTask).subscribe(() => {
        this.router.navigate(["tasks"])
      })
    }else {
      this.taskToEdit.caption = this.taskFormGroup.get("title")?.value
      this.taskToEdit.description = this.taskFormGroup.get("description")?.value
      this.taskToEdit.assignee = this.taskFormGroup.get("assignee")?.value
      this.taskToEdit.taskStatus = this.taskFormGroup.get("taskStatus")?.value
      this.taskToEdit.estimatedTime = this.createTimeMeasure()
      this.taskService.editTask(this.taskToEdit).subscribe(() =>{
        this.router.navigate(["tasks"])
      })
    }
  }

  createTimeMeasure(){
    let estimationTime = this.taskFormGroup.get("estimationTime")?.value.split(" ")
    return new TimeMeasure(estimationTime[0], estimationTime[1])
  }

  getStatus(): TaskStatus{
    if(this.taskFormGroup.get("assignee")?.value != null){
      return TaskStatus.IN_PROGRESS
    }else {
      return TaskStatus.UNASSIGNED
    }
  }

  navigateBack(){
    this.router.navigate(["tasks"])
  }
}
