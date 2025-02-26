/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.appium.java_client.pagefactory_tests;

import io.appium.java_client.android.BaseAndroidTest;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.HowToUseLocators;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AndroidPageObjectTest extends BaseAndroidTest {

    private boolean populated = false;

    @FindBy(className = "android.widget.TextView")
    private List<WebElement> textVieWs;

    @AndroidFindBy(className = "android.widget.TextView")
    private List<WebElement> androidTextViews;

    @AndroidFindBy(className = "android.widget.TextView")
    private List<WebElement> androidOriOsTextViews;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/text1\")")
    private List<WebElement> androidUIAutomatorViews;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/text1\")")
    private List<WebElement> mobileElementViews;

    @FindBy(className = "android.widget.TextView")
    private List<WebElement> mobiletextVieWs;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/text1\")")
    private List<RemoteWebElement> remoteElementViews;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")")
    @AndroidFindBy(className = "android.widget.TextView")
    private List<WebElement> chainElementViews;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/content\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")")
    @AndroidFindBy(id = "android:id/text1")
    private List<WebElement> chainAndroidOrIOSUIAutomatorViews;

    @FindBy(id = "android:id/text1")
    private WebElement textView;

    @AndroidFindBy(className = "android.widget.TextView")
    private WebElement androidTextView;

    @AndroidFindBy(className = "android.widget.TextView")
    private WebElement androidOriOsTextView;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/text1\")")
    private WebElement androidUIAutomatorView;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/text1\")")
    private WebElement mobileElementView;

    @FindBy(className = "android.widget.TextView")
    private WebElement mobiletextVieW;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/text1\")")
    private RemoteWebElement remotetextVieW;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")")
    @AndroidFindBy(className = "android.widget.TextView")
    private WebElement chainElementView;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/content\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")")
    @AndroidFindBy(id = "android:id/text1")
    private WebElement chainAndroidOrIOSUIAutomatorView;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/content\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")")
    @AndroidFindBy(id = "android:id/text1")
    private WebElement androidElementView;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/content\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")")
    @AndroidFindBy(id = "android:id/text1")
    private List<WebElement> androidElementViews;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/Fakecontent\")")
    @AndroidFindBy(id = "android:id/Faketext1")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")")
    //by this locator element is found
    @AndroidFindBy(id = "android:id/FakeId")
    private List<WebElement> findAllElementViews;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/Fakecontent\")")
    @AndroidFindBy(id = "android:id/Faketext1")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")")
    //by this locator element is found
    @AndroidFindBy(id = "android:id/FakeId")
    private WebElement findAllElementView;

    @AndroidFindBy(id = "android:id/text1")
    private WebElement textAndroidId;

    @FindBy(css = "e.e1.e2")
    private List<WebElement> elementsWhenAndroidLocatorIsNotDefinedAndThereIsInvalidFindBy;

    @FindBy(css = "e.e1.e2")
    private WebElement elementWhenAndroidLocatorIsNotDefinedAndThereIsInvalidFindBy;

    @FindBy(id = "fakeId")
    private WebElement fakeElement;

    @FindBy(id = "fakeId")
    private List<WebElement> fakeElements;

    @CacheLookup
    @FindBy(className = "android.widget.TextView")
    private WebElement cached;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/content\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")")
    @AndroidFindBy(id = "android:id/Faketext1")
    @AndroidFindBy(id = "android:id/text1")
    private WebElement elementFoundByInvalidChainedSelector;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/content\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")")
    @AndroidFindBy(id = "android:id/Faketext1")
    @AndroidFindBy(id = "android:id/text1")
    private List<WebElement> elementsFoundByInvalidChainedSelector;

    @AndroidFindBy(id = "android:id/text1", priority = 2)
    @AndroidFindAll(value = {
            @AndroidBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")"),
            @AndroidBy(id = "android:id/fakeId")}, priority = 1)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/content\")")
    private WebElement androidElementViewFoundByMixedSearching;

    @AndroidFindBy(id = "android:id/text1", priority = 2)
    @AndroidFindAll(value = {
            @AndroidBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")"),
            @AndroidBy(id = "android:id/fakeId")}, priority = 1)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/content\")")
    private List<WebElement> androidElementsViewFoundByMixedSearching;

    @AndroidFindBys({
            @AndroidBy(uiAutomator = "new UiSelector().resourceId(\"android:id/content\")", priority = 1),
            @AndroidBy(className = "android.widget.FrameLayout")})
    @AndroidFindBys({@AndroidBy(id = "android:id/text1", priority = 1),
            @AndroidBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")")})
    private WebElement androidElementViewFoundByMixedSearching2;

    @AndroidFindBys({
            @AndroidBy(uiAutomator = "new UiSelector().resourceId(\"android:id/content\")", priority = 1),
            @AndroidBy(className = "android.widget.FrameLayout")})
    @AndroidFindBys({
            @AndroidBy(id = "android:id/text1", priority = 1),
            @AndroidBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")")})
    private List<WebElement> androidElementsViewFoundByMixedSearching2;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(id = "android:id/fakeId1")
    @AndroidFindBy(id = "android:id/fakeId2", priority = 1)
    @AndroidFindBys(value = {
            @AndroidBy(uiAutomator = "new UiSelector().resourceId(\"android:id/content\")", priority = 1),
            @AndroidBy(id = "android:id/text1", priority = 3),
            @AndroidBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")", priority = 2),
            @AndroidBy(className = "android.widget.FrameLayout")}, priority = 2)
    @AndroidFindBy(id = "android:id/fakeId3", priority = 3)
    @AndroidFindBy(id = "android:id/fakeId4", priority = 4)
    private WebElement androidElementViewFoundByMixedSearching3;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(id = "android:id/fakeId1")
    @AndroidFindBy(id = "android:id/fakeId2", priority = 1)
    @AndroidFindBys(value = {
            @AndroidBy(uiAutomator = "new UiSelector().resourceId(\"android:id/content\")", priority = 1),
            @AndroidBy(id = "android:id/text1", priority = 3),
            @AndroidBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")", priority = 2),
            @AndroidBy(className = "android.widget.FrameLayout")}, priority = 2)
    @AndroidFindBy(id = "android:id/fakeId3", priority = 3)
    @AndroidFindBy(id = "android:id/fakeId4", priority = 4)
    private List<WebElement> androidElementsViewFoundByMixedSearching3;

    /**
     * The setting up.
     */
    @BeforeEach public void setUp() {
        if (!populated) {
            //This time out is set because test can be run on slow Android SDK emulator
            PageFactory.initElements(new AppiumFieldDecorator(driver, ofSeconds(5)), this);
        }

        populated = true;
    }

    @Test public void findByElementsTest() {
        assertNotEquals(0, textVieWs.size());
    }

    @Test public void findByElementTest() {
        assertNotEquals(null, textView.getAttribute("text"));
    }


    @Test public void androidFindByElementsTest() {
        assertNotEquals(0, androidTextViews.size());
    }

    @Test public void androidFindByElementTest() {
        assertNotEquals(null, androidTextView.getAttribute("text"));
    }

    @Test public void androidOrIOSFindByElementsTest() {
        assertNotEquals(0, androidOriOsTextViews.size());
    }

    @Test public void androidOrIOSFindByElementTest() {
        assertNotEquals(null, androidOriOsTextView.getAttribute("text"));
    }

    @Test public void androidFindByUIAutomatorElementsTest() {
        assertNotEquals(0, androidUIAutomatorViews.size());
    }

    @Test public void androidFindByUIAutomatorElementTest() {
        assertNotEquals(null, androidUIAutomatorView.getAttribute("text"));
    }

    @Test public void areMobileElementsTest() {
        assertNotEquals(0, mobileElementViews.size());
    }

    @Test public void isMobileElementTest() {
        assertNotEquals(null, mobileElementView.getAttribute("text"));
    }

    @Test public void areMobileElementsFindByTest() {
        assertNotEquals(0, mobiletextVieWs.size());
    }

    @Test public void isMobileElementFindByTest() {
        assertNotEquals(null, mobiletextVieW.getAttribute("text"));
    }

    @Test public void areRemoteElementsTest() {
        assertNotEquals(0, remoteElementViews.size());
    }

    @Test public void isRemoteElementTest() {
        assertNotEquals(null, remotetextVieW.getAttribute("text"));
    }

    @Test public void androidChainSearchElementsTest() {
        assertNotEquals(0, chainElementViews.size());
    }

    @Test public void androidChainSearchElementTest() {
        assertNotEquals(null, chainElementView.getAttribute("text"));
    }

    @Test public void androidOrIOSFindByElementsTestChainSearches() {
        assertNotEquals(0, chainAndroidOrIOSUIAutomatorViews.size());
    }

    @Test public void androidOrIOSFindByElementTestChainSearches() {
        assertNotEquals(null, chainAndroidOrIOSUIAutomatorView.getAttribute("text"));
    }

    @Test public void isAndroidElementTest() {
        assertNotEquals(null, androidElementView.getAttribute("text"));
    }

    @Test public void areAndroidElementsTest() {
        assertNotEquals(0, androidElementViews.size());
    }

    @Test public void findAllElementTest() {
        assertNotEquals(null, findAllElementView.getAttribute("text"));
    }

    @Test public void findAllElementsTest() {
        assertNotEquals(0, findAllElementViews.size());
    }

    @Test public void findByAndroidAnnotationOnlyTest() {
        assertNotEquals(null, textAndroidId.getAttribute("text"));
    }

    @Test public void checkThatTestWillNotBeFailedBecauseOfInvalidFindBy() {
        assertThrows(NoSuchElementException.class,
            () -> elementWhenAndroidLocatorIsNotDefinedAndThereIsInvalidFindBy.getAttribute("text"));
    }

    @Test public void checkThatTestWillNotBeFailedBecauseOfInvalidFindByList() {
        assertEquals(0, elementsWhenAndroidLocatorIsNotDefinedAndThereIsInvalidFindBy.size());
    }

    @Test public void checkThatClassObjectMethodsDoNotInvokeTheSearching() {
        assertTrue(WebElement.class.isAssignableFrom(fakeElement.getClass()));
        assertNotEquals(WebElement.class, fakeElement.getClass());
        assertEquals(driver, ((WrapsDriver) fakeElement).getWrappedDriver());
    }

    @Test public void checkThatClassObjectMethodsDoNotInvokeTheSearchingOfElementLest() {
        assertTrue(List.class.isAssignableFrom(fakeElements.getClass()));
        assertNotEquals(ArrayList.class, fakeElements.getClass());
    }

    @Test public void checkCached() {
        assertEquals(((RemoteWebElement) cached).getId(), ((RemoteWebElement) cached).getId());
    }

    @Test
    public void checkThatElementSearchingThrowsExpectedExceptionIfChainedLocatorIsInvalid() {
        assertThrows(NoSuchElementException.class, () -> elementFoundByInvalidChainedSelector.getAttribute("text"));
    }

    @Test public void checkThatListSearchingWorksIfChainedLocatorIsInvalid() {
        assertEquals(0, elementsFoundByInvalidChainedSelector.size());
    }

    @Test public void checkMixedElementSearching1() {
        assertNotNull(androidElementViewFoundByMixedSearching.getAttribute("text"));
    }

    @Test public void checkMixedElementsSearching1() {
        assertNotEquals(0, androidElementsViewFoundByMixedSearching.size());
    }

    @Test public void checkMixedElementSearching2() {
        assertNotNull(androidElementViewFoundByMixedSearching2.getAttribute("text"));
    }

    @Test public void checkMixedElementsSearching2() {
        assertNotEquals(0, androidElementsViewFoundByMixedSearching2.size());
    }

    @Test public void checkMixedElementSearching3() {
        assertNotNull(androidElementViewFoundByMixedSearching3.getAttribute("text"));
    }

    @Test public void checkMixedElementsSearching3() {
        assertNotEquals(0, androidElementsViewFoundByMixedSearching3.size());
    }
}
