import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {LoggedWork} from "../model/LoggedWork";

@Injectable({
  providedIn: 'root'
})
export class LoggedService {

  constructor(private http: HttpClient) { }
  private readonly apiUrl = 'http://localhost:8080';

  getUserLoggedWork(): Observable<LoggedWork[]>{
    const url = `${this.apiUrl}/user-logged`
    return this.http.get<LoggedWork[]>(url)
  }

  addLoggedWork(loggedWork: LoggedWork): Observable<any>{
    const url = `${this.apiUrl}/add-logged`
    return this.http.post(url, loggedWork)
  }
}
