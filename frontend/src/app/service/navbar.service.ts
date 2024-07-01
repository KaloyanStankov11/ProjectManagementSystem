import {Injectable} from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class NavbarService {

  showNavBar: BehaviorSubject<boolean>
  showManagerPanel: BehaviorSubject<boolean>

  constructor() {
    this.showNavBar = new BehaviorSubject(true)
    this.showManagerPanel = new BehaviorSubject(false)
  }

  hide() {
    this.showNavBar.next(false)
  }

  display() {
    this.showNavBar.next(true)
  }

  hideManagerPanel() {
    this.showManagerPanel.next(false)
  }

  displayManagerPanel() {
    this.showManagerPanel.next(true)
  }
}
