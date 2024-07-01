import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Task} from "../model/Task";
import {HttpClient} from "@angular/common/http";
import {APP_URL} from "../Constants";
import {LoggedWork} from "../model/LoggedWork";

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private readonly apiUrl = APP_URL + 'task';

  constructor(private http: HttpClient) {
  }
  getAllTasks(): Observable<Task[]>{
    const url = `${this.apiUrl}/allTasks`
    return this.http.get<any>(url)
  }

  createTask(task: Task): Observable<any>{
    const url = `${this.apiUrl}/create`
    return this.http.post<any>(url, task)
  }

  getProjectTasks(project: string): Observable<Task[]>{
    const url = `${this.apiUrl}/project-tasks/${project}`
    return this.http.get<Task[]>(url)
  }

  getTaskLoggedWork(taskId: number): Observable<any>{
    const url = `${this.apiUrl}/task-logged/${taskId}`
    let requestOptions: Object = {
      responseType: 'text'
    }
    return this.http.get<any>(url, requestOptions)
  }

  deleteTask(id: number): Observable<any>{
    const url = `${this.apiUrl}/delete/${id}`
    return this.http.delete(url)
  }

  editTask(task: Task): Observable<any>{
    const url = `${this.apiUrl}/update`
    return this.http.post<any>(url, task)
  }

  getUserTasks(): Observable<any>{
    const url = `${this.apiUrl}/user-tasks`
    return this.http.get(url)
  }
}
