import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Task} from "../model/Task";
import {Injectable} from "@angular/core";
import {TaskService} from "../service/task.service";
import {Observable} from "rxjs";

@Injectable({
  providedIn: "root"
})
export class TasksResolver implements Resolve<Task[]>{
  constructor(private taskService: TaskService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Task[]> {
    return this.taskService.getAllTasks();
  }
}
