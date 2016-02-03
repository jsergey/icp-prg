package ru.scrumtrek.trainings.icpprg.twitrek.jbehave;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.scrumtrek.trainings.icpprg.twitrek.jbehave.steps.UserCanRegister;
import ru.scrumtrek.trainings.icpprg.twitrek.jbehave.steps.UserCanSeeTweets;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

import java.util.List;


@RunWith(AnnotatedEmbedderRunner.class)
@Configure(storyLoader = JBehaveTest.StoryLoader.class,
        storyReporterBuilder = JBehaveTest.ReportBuilder.class)
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = false,
        ignoreFailureInView = true, verboseFailures = true)
@UsingSteps(instances = { UserCanSeeTweets.class, UserCanRegister.class})
public class JBehaveTest extends InjectableEmbedder {


    @Test
    public void run() throws Throwable {
        List<String> storyPaths = new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "");
        injectedEmbedder().runStoriesAsPaths(storyPaths);
    }

    public static class StoryLoader extends LoadFromClasspath {

        public StoryLoader() {
            super(JBehaveTest.class.getClassLoader());
        }
    }

    public static class ReportBuilder extends StoryReporterBuilder {

        public ReportBuilder() {
            this.withFormats(org.jbehave.core.reporters.Format.CONSOLE).withDefaultFormats();
        }
    }


}
