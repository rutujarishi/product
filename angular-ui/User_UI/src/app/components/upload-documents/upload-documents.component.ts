import { Component, OnInit} from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UploadDocumentsService } from '../../services/upload-documents.service';
import { User } from '../../util';

@Component({
  selector: 'app-upload-documents',
  templateUrl: './upload-documents.component.html',
  styleUrls: ['./upload-documents.component.css']
})
export class UploadDocumentsComponent implements OnInit {
  public userFile: any = File;
  public userFiles: any = File;
  private minDate = new Date(1947, 1, 1);
  private maxDate = new Date(2016, 1, 1);
  profile: any = FormGroup;
  firstname = '';
  lastname = '';
  gender = 'female';
  email = new FormControl('', [Validators.required, Validators.email]);
  aadharNo: number;
   AllUsers = [];
  private dob: Date;

  getErrorMessage() {
    return this.email.hasError('required') ? 'You must enter a value' :
      this.email.hasError('email') ? 'Not a valid email' :
        '';
  }
  constructor( private signup: UploadDocumentsService) { 

  }
  fileuploads(event) {
    const file = event.target.files[0];
    this.userFile = file;
    console.log(this.userFile);
  }

  ngOnInit() : void {
  }
  save() {
    const user = new User();
    user.firstname = this.firstname;
    user.lastname = this.lastname;
    user.aadharNo = this.aadharNo;
    user.email = this.email.value;
    user.gender = this.gender;
    user.dob =  this.dob;
    console.log(this.dob)
    const formData = new FormData();
    formData.append('user', JSON.stringify(user));
    formData.append('file', this.userFile);
    formData.append('files', this.userFiles);
    this.signup.saveUser(formData).subscribe(res => {
      console.log(res);
    });
  }

  fileupload(event) {
    const files = event.target.files[0];
    this.userFiles = files;
    console.log(this.userFiles);
  }
}


