//
//  CardMatchingGame.h
//  DemoMatchismo
//


#import <Foundation/Foundation.h>
#import "Deck.h"

@interface CardMatchingGame : NSObject

// designated initializer
- (instancetype) initWithCardCount:(NSUInteger)count usignDeck:(Deck *)deck;
@property(nonatomic,readonly)NSInteger score;
-(void) chooseCardAtIndex:(NSUInteger) index;
-(Card *) cardAtIndex:(NSUInteger)index;

@end
