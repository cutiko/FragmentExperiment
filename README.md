# FragmentExperiment
What is under the hood of the Fragment Manager?

I have always wonder what actually happens when the `Fragments` are attached to the host, so I made this little project to play arround.
There is a lot more to test and learn, but this seems like a good start.

## How to?
Clone, run the app, look at the logcat, the tag is `VIEW_ITERATOR`. Press the fab, look at the logcat again.

### XML Tag Fragment
When we use the xml `<fragment>` tag the process seems to replace the the `id` of the `Fragment` root view.

 - On `onViewCreated` the root view still has the `id` from the layout
 - On `onStart` the root view has the `id` from the `<fragment>` xml tag
 
### Dynamic Fragment
When we use the `FragmentTransaction` the `Fragment` is attached inside the container. This seems more intuitive and predictable.

 - The `id` of the `Fragment` root view, won't be changed
 - The root view of the `Fragment` is inside the `ViewGroup` used as container
 
 
### Layout Inspector
We can confirm the findings by using at the Layout Inspector tool

![Layout Inspector Result](https://raw.githubusercontent.com/cutiko/FragmentExperiment/master/app/src/main/res/drawable/li_1.png)

**Contributions are welcome**, there are other cases to test yet:

 - Replacing a `Fragment``
 - Adding a `Fragment` with tag
 - Adding a `Fragment` with tag but without user interface
 - Removing a `Fragment``
 - What happens if we use `ViewPager` with a `FragmentPagerAdaper`
