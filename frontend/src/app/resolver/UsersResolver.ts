import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Task} from "../model/Task";
import {TaskService} from "../service/task.service";
import {Observable} from "rxjs";
import {AppUser} from "../model/AppUser";
import {UserService} from "../service/user.service";

@Injectable({
  providedIn: "root"
})
export class UsersResolver implements Resolve<AppUser[]>{
  constructor(private userService: UserService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<AppUser[]> {
    return this.userService.getAllUsers();
  }
}
