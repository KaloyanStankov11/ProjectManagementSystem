import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";
import {APP_URL} from "../Constants";
import {HttpClient} from "@angular/common/http";
import {Project} from "../model/Project";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private selectedProjectSubject = new BehaviorSubject<string>("");
  selectedProject$ = this.selectedProjectSubject.asObservable();
  private readonly apiUrl = APP_URL + 'projects';

  constructor(private http: HttpClient) {
  }

  setSelectedProject(project: string) {
    this.selectedProjectSubject.next(project);
  }

  getSelectedProject() {
    return this.selectedProjectSubject.value;
  }

  getAllProjects(){
    const url = `${this.apiUrl}/allProjects`
    return this.http.get<Project[]>(url)
  }
}
