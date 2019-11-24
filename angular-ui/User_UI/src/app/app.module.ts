import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AppRoutingModule,routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './components/material/material.module';
import { UserDashboardComponent } from './components/user-dashboard/user-dashboard.component';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { UploadDocumentsComponent } from './components/upload-documents/upload-documents.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UploadDocumentsService } from './services/upload-documents.service';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { FlexLayoutModule} from '@angular/flex-layout';
import { XyzComponent } from './components/xyz/xyz.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { FooterComponent } from './components/footer/footer.component'

@NgModule({
  declarations: [
    AppComponent,
    UserDashboardComponent,
    LandingPageComponent,
    UploadDocumentsComponent,
    routingComponents,
    XyzComponent,
    NavBarComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FlexLayoutModule
  ],
  providers: [UploadDocumentsService],
  bootstrap: [AppComponent],
  schemas:[CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
