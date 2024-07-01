import {Task} from "./Task";

export class DialogData {
  title: string;
}

export class ConfirmationDialogData extends DialogData {
  message: string;
}

export class AddLogDialogData extends DialogData{
  tasks: Task[]
}
