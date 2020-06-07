#import <StoreKit/StoreKit.h>


<SKStoreProductViewControllerDelegate>



- (void)openAppWithIdentifier:(NSString *)appId {

  SKStoreProductViewController *storeProductVC = [[SKStoreProductViewController  alloc] init];

 storeProductVC.delegate = self;

  NSDictionary *dict = [NSDictionary  dictionaryWithObject:appId forKey:SKStoreProductParameterITunesItemIdentifier];

 [storeProductVC loadProductWithParameters:dict completionBlock:^(BOOL result, NSError *error) {

 if (result) {

 [self presentViewController:storeProductVC animated:YES completion:nil];

 }

 }];

}

- (void)productViewControllerDidFinish:(SKStoreProductViewController *)storeProductVC {

 [storeProductVC dismissViewControllerAnimated:YES  completion:^{

 [self.navigationController  popToRootViewControllerAnimated:YES];

 }];

}
