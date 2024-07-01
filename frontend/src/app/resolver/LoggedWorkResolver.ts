import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Observable} from "rxjs";
import {LoggedWork} from "../model/LoggedWork";
import {LoggedService} from "../service/logged.service";

@Injectable({
  providedIn: "root"
})
export class LoggedWorkResolver implements Resolve<LoggedWork[]>{
  constructor(private loggedService: LoggedService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<LoggedWork[]> {
    return this.loggedService.getUserLoggedWork();
  }
}
