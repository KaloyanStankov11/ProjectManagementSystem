import {Component, EventEmitter, Inject, Output} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {AddLogDialogData, DialogData} from "../../../model/DialogData";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Task} from "../../../model/Task";
import {LoggedWork} from "../../../model/LoggedWork";
import {AppUser} from "../../../model/AppUser";

@Component({
  selector: 'app-add-log-modal',
  templateUrl: './add-log-modal.component.html',
  styleUrls: ['./add-log-modal.component.scss']
})
export class AddLogModalComponent {

  @Output() onDialogClosed: EventEmitter<any> = new EventEmitter<any>()
  loggedWork: FormGroup
  userTasks: Task[]
  title: string
  constructor(public dialogRef: MatDialogRef<AddLogModalComponent>,
              @Inject(MAT_DIALOG_DATA) public data: AddLogDialogData,
              public fb: FormBuilder) {
    this.loggedWork = fb.group({
      date: fb.control(null),
      task: fb.control(null),
      time: fb.control(""),
      project: fb.control(null)
    })
  }

  close(): void{
    this.dialogRef.close()
  }

  onSubmit(){
    const logged = new LoggedWork(
      new AppUser(),
      this.loggedWork.get("project")?.value,
      this.loggedWork.get("task"))
  }
}
