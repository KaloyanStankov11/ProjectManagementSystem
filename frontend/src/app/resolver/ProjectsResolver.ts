import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Task} from "../model/Task";
import {TaskService} from "../service/task.service";
import {Observable} from "rxjs";
import {Project} from "../model/Project";
import {ProjectService} from "../service/project.service";

@Injectable({
  providedIn: "root"
})
export class ProjectsResolver implements Resolve<Project[]>{
  constructor(private projectService: ProjectService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Project[]> {
    return this.projectService.getAllProjects();
  }
}
