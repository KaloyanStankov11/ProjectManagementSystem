import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {LoginResponse} from "../model/LoginResponse";
import {AppUser, RegisterUserRequest} from "../model/AppUser";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  private readonly apiUrl = 'http://localhost:8080';

  login(username: string, password: string): Observable<LoginResponse> {
    window.localStorage.clear()
    let user = new AppUser(username, null, password, null, null, null, null, null)
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'User-Information': JSON.stringify(user)
    })
    return this.http.get<LoginResponse>(`${this.apiUrl}/login`, {headers})
  }

  getAllUsers(): Observable<AppUser[]> {
    const url = `${this.apiUrl}/users/all`
    return this.http.get<AppUser[]>(url)
  }

  getActiveUser(): Observable<AppUser> {
    const url = `${this.apiUrl}/users/active`
    return this.http.get<AppUser>(url)
  }

  deleteUser(userId: number): Observable<any> {
    const url = `${this.apiUrl}/users/delete-user/${userId}`
    return this.http.delete(url)
  }

  createUser(request: RegisterUserRequest): Observable<any> {
    const url = `${this.apiUrl}/users/save`
    return this.http.post(url, request)
  }

  logOut() {
    window.localStorage.clear();
  }

}
