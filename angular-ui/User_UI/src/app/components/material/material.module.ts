import { NgModule } from '@angular/core';
import {CommonModule} from '@angular/common';
import {MatButtonModule, MatToolbarModule, MatStepperModule,MatSidenavModule,MatListModule,MatIconModule,MatCardModule,MatTabsModule,MatFormFieldModule, MatDatepickerModule, MatRadioModule,MatNativeDateModule, MatInputModule} from '@angular/material';

const MaterialComponents =[
  MatButtonModule,MatToolbarModule,MatStepperModule,MatSidenavModule,MatListModule,MatIconModule,MatCardModule,MatTabsModule,MatFormFieldModule,MatDatepickerModule,MatRadioModule,MatNativeDateModule, MatInputModule
]

@NgModule({
  
  imports: [MaterialComponents,CommonModule
   
  ],
  exports: [MaterialComponents

  ]
})
export class MaterialModule { }
