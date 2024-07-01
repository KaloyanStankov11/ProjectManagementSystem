import {Component, OnInit} from '@angular/core';
import {LoggedWork} from "../../model/LoggedWork";
import {MatDialog} from "@angular/material/dialog";
import {AddLogModalComponent} from "./add-log-modal/add-log-modal.component";
import {take} from "rxjs";
import {Task} from "../../model/Task";
import {ActivatedRoute} from "@angular/router";
import {LoggedService} from "../../service/logged.service";
import {Project} from "../../model/Project";

@Component({
  selector: 'app-logged-work',
  templateUrl: './logged-work.component.html',
  styleUrls: ['./logged-work.component.scss']
})
export class LoggedWorkComponent implements OnInit{
  loggedWork: LoggedWork[]
  tasks: Task[]
  loggedWorkTableColumns = ["TASK", "TIME", "DATE", "ACTIONS"]

  constructor(public dialog: MatDialog, private route: ActivatedRoute, public loggedService: LoggedService) {
  }

  ngOnInit(): void {
    this.tasks = this.route.snapshot.data["tasks"]
    this.loggedWork = this.route.snapshot.data["logged"]
  }
  addLog(){
    this.dialog.open(AddLogModalComponent,{
      data: {
        title: "Add log for work",
        tasks: this.tasks
      }
    }).afterClosed()
      .pipe(take(1))
      .subscribe(response =>{
        if(response){
          this.loggedService.addLoggedWork(response).subscribe(newData =>{
            this.loggedWork = newData
          })
        }
      })
  }
  deleteLog(logged: LoggedWork) {
    this.loggedService.deleteLoggedWork(logged.id).subscribe(() =>{
      this.loggedService.getUserLoggedWork().subscribe(data =>{
        this.loggedWork = data
      })
    })
  }

}
