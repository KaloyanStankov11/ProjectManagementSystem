import { Component } from '@angular/core';
import {LoggedWork} from "../../model/LoggedWork";
import {MatDialog} from "@angular/material/dialog";
import {AddLogModalComponent} from "./add-log-modal/add-log-modal.component";
import {take} from "rxjs";

@Component({
  selector: 'app-logged-work',
  templateUrl: './logged-work.component.html',
  styleUrls: ['./logged-work.component.scss']
})
export class LoggedWorkComponent {
  loggedWork: LoggedWork[]

  loggedWorkTableColumns = ["TASK", "TIME", "TIME_LEFT", "DATE", "ACTIONS"]

  constructor(public dialog: MatDialog) {
  }

  addLog(){
    this.dialog.open(AddLogModalComponent,{
      data: {
        title: "Add log for work",
        tasks: []
      }
    }).afterClosed()
      .pipe(take(1))
      .subscribe()
  }
  deleteTask() {

  }

  editTask() {

  }
}
