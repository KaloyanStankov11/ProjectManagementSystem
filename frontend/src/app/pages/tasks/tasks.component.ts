import {Component, OnInit} from '@angular/core';
import {Task} from "../../model/Task";
import {ActivatedRoute, Router} from "@angular/router";
import {TaskService} from "../../service/task.service";
import {ProjectService} from "../../service/project.service";
import {NavbarService} from "../../service/navbar.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.scss']
})
export class TasksComponent implements OnInit{
  tasks: Task[]
  columnsToDisplay = ["CAPTION", "CREATED", "PROJECT", "STATUS", "ASSIGNEE", "ACTIONS"]
  activeProject: string
  isManager: boolean
  subscribers: Subscription[] = []
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private projectService: ProjectService,
    private taskService: TaskService,
    private navBarService: NavbarService) {
  }

  ngOnInit(): void {
    // this.tasks = this.route.snapshot.data["tasks"]
    this.subscribers.push(this.navBarService.showManagerPanel.subscribe((value) => {
      this.isManager = value
    }))
    this.activeProject = this.projectService.getSelectedProject()
    this.loadProjects()
    this.projectService.selectedProject$.subscribe(newProject =>{
      this.activeProject = newProject
      this.loadProjects()
    })
  }

  loadProjects(){
    this.taskService.getProjectTasks(this.activeProject).subscribe(tasks =>{
      this.tasks = tasks
    })
  }
  deleteTask(task: Task) {
    this.taskService.deleteTask(task.id).subscribe()
    this.tasks = this.tasks.filter(it => it.id != task.id)
  }

  editTask(task: Task) {
    this.router.navigate(["edit-task"], {state: {task: task, edit: true}})
  }

  goToAddTask() {
    this.router.navigate(["create-task"], {state: {edit: false}})
  }

  overviewTask(task: Task) {
    this.router.navigate(["task-overview"], {state: {task: task}})
  }
}
