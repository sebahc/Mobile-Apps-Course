//
//  ViewController.h
//  MyDemo
//
//  Created by sebahc on 9/24/14.
//  Copyright (c) 2014 Sebastian J Herrera Cano. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController<UICollectionViewDataSource, UICollectionViewDelegate>
@property (weak, nonatomic) IBOutlet UICollectionView *someCollectionView;
@property (strong,nonatomic) NSMutableArray *menuItems;



@end
